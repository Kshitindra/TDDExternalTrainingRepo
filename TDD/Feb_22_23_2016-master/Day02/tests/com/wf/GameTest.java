package com.wf;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	private void assignTarget(int target){
		Class cls = game.getClass();
		try {
			Field targetField =  cls.getDeclaredField("target");
			targetField.setAccessible(true);
			targetField.set(game, target);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAttemptsAfterInvalidInput(){
		assignTarget(77);
		try{
			game.play(-1);
		}
		catch(Exception ex){
			//Left Blank intentionally
		}
		assertTrue(game.getAttempts() == 1);
	}
	
	
	@Test(expected=GameException.class)
	public void testInvalidInput(){
		assignTarget(77);
		game.play(-1);
	}
	
	@Test
	public void testPlayANewGame(){
		assignTarget(77);
		game.play(50);
		game.play(75);
		game.play(77);
		game.reset();
		assertTrue(game.getAttempts() == 0);
		assertTrue(game.getMessage() == null);
		assertTrue(!game.isGameOver());
	}
	
	
	@Test(expected=GameOverException.class)
	public void testGameIsOver(){
		assignTarget(77);
		game.play(50);
		game.play(75);
		game.play(77);
		game.play(90);
	}
	
	@Test
	public void testAttempts(){
		assignTarget(77);
		game.play(50);
		game.play(75);
		game.play(77);
		assertTrue(game.getAttempts() == 3);
	}
	
	@Test
	public void testMessageIsYouHaveGotIt(){
		assignTarget(75);
		int guess = 75;
		game.play(guess);
		assertTrue("You've got it!!!".equals(game.getMessage()));
	}
	
	@Test
	public void testMessageIsAimLower(){
		assignTarget(75);
		int guess = 80;
		game.play(guess);
		assertTrue("Aim Lower".equals(game.getMessage()));
	}
	
	@Test
	public void testMessageIsAimHigher(){
		int guess = game.getTarget() - 1;
		game.play(guess);
		assertTrue("Aim Higher".equals(game.getMessage()));
	}
	
	@Test
	public void testMessageToBeNullInTheBeginning(){
		String message = game.getMessage();
		assertNull(message);
	}
	
	@Test
	public void testAttemptsToBeZeroInTheBeginning(){
		int attempts = game.getAttempts();
		assertTrue(attempts == 0);
	}
	
	@Test
	public void testRandomNumberBetween1And100(){
		int target = game.getTarget();
		assertTrue(target > 0 && target < 100);
	}
	
	@Test
	public void testGenerateRandomNumber(){
		int target = game.getTarget();
		assertTrue(target != 0);
	}
	
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
		game = null;
	}

	@Test
	public void testSetup() {
		assertNotNull(game);
	}

}
