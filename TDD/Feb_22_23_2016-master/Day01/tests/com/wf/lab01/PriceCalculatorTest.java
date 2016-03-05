package com.wf.lab01;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PriceCalculatorTest {

	private PriceCalculator priceCalculator;
	
	@Test
	public void testPriceOfSevenA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 50, 3, 130.0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",7);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(310 == total);
	}
	
	@Test
	public void testPriceOfSixA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 50, 3, 130.0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",6);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(260 == total);
	}
	
	@Test
	public void testPriceOfFiveA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 50, 3, 130.0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",5);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(230 == total);
	}
	
	@Test
	public void testPriceOfFourA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 50, 3, 130.0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",4);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(180 == total);
	}
	
	@Test
	public void testPriceOfThreeA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 50, 3, 130.0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",3);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(130 == total);
	}
	
	
	@Test
	public void testPriceOfTwoA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 40, 0, 0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",2);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(80 == total);
	}
	
	
	@Test
	public void testPriceOfAnotherA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 140, 0, 0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",1);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(140 == total);
	}
	
	@Test
	public void testPriceOfOneA(){
		PriceRules priceRules = new PriceRules();
		priceRules.add("A", 40, 0, 0);
		priceCalculator.setPriceRules(priceRules);
		Map<String, Integer> items = new HashMap<>();
		items.put("A",1);
		double total = priceCalculator.calculateTotalPrice(items);
		assertTrue(40 == total);
	}
	
	
	
	@Before
	public void setUp() throws Exception {
		priceCalculator = new PriceCalculator();
	}

	@After
	public void tearDown() throws Exception {
		priceCalculator = null;
	}

	@Test
	public void testSetup() {
		assertNotNull(priceCalculator);
	}

}
