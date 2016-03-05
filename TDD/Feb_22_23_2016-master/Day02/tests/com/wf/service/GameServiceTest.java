package com.wf.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wf.GameEngine;
import com.wf.GameRepository;

public class GameServiceTest {

	private GameService gameService;
	
	private class MockGameEngine implements GameEngine{
		public void play(int guess){
		}
		public int getAttempts(){
			return 1;
		}
		public String getMessage(){
			return "Aim Higher";
		}
		public int getTarget(){
			return 77;
		}
	}
	private class MockGameRepository implements GameRepository{

		public boolean storeResults(String name, int target, int attempts) {
			return true;
		}
		
	}
	
	@Test
	public void storeResultsInRepository(){
		gameService.setGameEngine(new MockGameEngine());
		gameService.setGameRepository(new MockGameRepository());
		String name = "Sam";
		boolean stored = gameService.store(name);
		assertTrue(stored);
	}
	
	@Test
	public void testResponseOfPlay(){
		gameService.setGameEngine(new MockGameEngine());
		int guess = 50;
		GameDTO gameDTO =  gameService.play(guess);
		assertTrue(gameDTO.getAttempts() == 1);
		assertTrue("Aim Higher".equals(gameDTO.getMessage()));
	}
	
	@Test
	public void testPlay(){
		gameService.setGameEngine(new MockGameEngine());
		int guess = 50;
		Object response = gameService.play(guess);
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
