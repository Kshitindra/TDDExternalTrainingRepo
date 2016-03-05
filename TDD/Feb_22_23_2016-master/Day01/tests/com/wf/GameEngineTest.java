package com.wf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {

	@Test(expected=GameEngineException.class)
	public void testIfNumberIsDivisibleByZero(){
		int num = 0;
		gameEngine.play(num);
	}
	
	@Test
	public void testIfNumberIsEvenAndDivisibleBy3And5(){
		int num = 30;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.EXTREMELY_HOT.equals(output));
	}
	@Test
	public void testIfNumberIsEvenAndDivisibleBy5(){
		int num = 10;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.EVEN_HOTTER.equals(output));
	}
	@Test
	public void testIfNumberIsEvenAndDivisibleBy3(){
		int num = 6;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.EVEN_HOT.equals(output));
	}
	@Test
	public void testIfNumberIsEven(){
		int num = 2;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.EVEN.equals(output));
	}
	
	@Test
	public void testIfAnotherNumberIsDivisibleBy3And5(){
		int num = 75;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.HOT_AND_HOTTER.equals(output));
	}
	
	@Test
	public void testIfNumberIsDivisibleBy3And5(){
		int num = 15;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.HOT_AND_HOTTER.equals(output));
	}
	
	@Test
	public void testIfNumberIsDivisibleBy5(){
		int num = 25;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.HOTTER.equals(output));
	}
	
	@Test
	public void testIfNumberIsDivisibleBy3(){
		int num = 9;
		String output = (String)gameEngine.play(num);
		assertTrue(Messages.HOT.equals(output));
	}
	
	@Test
	public void testInputANumberAndCheckIfOutputIsThatNumber(){
		int num = 7;
		int output = (int)gameEngine.play(num);
		assertTrue(output == 7);
	}
	
	@Test
	public void testOutputMap(){
		assertNotNull(gameEngine.getOutputMap());
		assertTrue(gameEngine.getOutputMap().size() >= 3);
	}
	
	
	
	
	private GameEngine gameEngine;

	@Before
	public void setup(){
		gameEngine = new GameEngine();
	}
	
	@Test
	public void testSetup() {
		assertNotNull(gameEngine);
	}

}
