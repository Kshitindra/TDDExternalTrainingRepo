package com.wf.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.wf.GameEngine;
import com.wf.GameRepository;

public class GameServiceUsingMockitoTest {

	private GameService gameService;
	
		
	@Test
	public void storeResultsInRepository(){
		GameEngine gameEngine = mock(GameEngine.class);
		GameRepository gameRepository = mock(GameRepository.class);
		gameService.setGameEngine(gameEngine);
		when(gameEngine.getTarget()).thenReturn(77);
		when(gameEngine.getAttempts()).thenReturn(1);
		String name = "Sam";
		when(gameRepository.storeResults(name, 77, 1)).thenReturn(true);

		gameService.setGameRepository(gameRepository);
		boolean stored = gameService.store(name);
		assertTrue(stored);
		verify(gameRepository,times(1)).storeResults(name, 77, 1);
	}
	
	@Test
	public void testResponseOfPlay(){
		GameEngine gameEngine = mock(GameEngine.class);
		gameService.setGameEngine(gameEngine);
		when(gameEngine.getAttempts()).thenReturn(1);
		when(gameEngine.getMessage()).thenReturn("Aim Higher");
		int guess = 50;
		GameDTO gameDTO =  gameService.play(guess);
		assertTrue(gameDTO.getAttempts() == 1);
		assertTrue("Aim Higher".equals(gameDTO.getMessage()));
	}
	
	@Test
	public void testPlay(){
		GameEngine gameEngine = mock(GameEngine.class);
		doNothing().when(gameEngine).play(50);
		gameService.setGameEngine(gameEngine);
		int guess = 50;
		Object response = gameService.play(guess);
		verify(gameEngine,times(1)).play(50);
		assertNotNull(response);
	}
	
	
	@Before
	public void setUp() throws Exception {
		gameService = new GameService();
	}

	@After
	public void tearDown() throws Exception {
		gameService = null;
	}
	@Test
	public void testSetup(){
		assertNotNull(gameService);
	}


}
