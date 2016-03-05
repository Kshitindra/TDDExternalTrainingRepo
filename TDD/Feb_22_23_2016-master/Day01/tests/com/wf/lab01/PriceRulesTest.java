package com.wf.lab01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PriceRulesTest {

	private PriceRules priceRules;
	
	@Test
	public void testDesignRuleForAnItemA(){
		String itemName = "A";
		double unitPrice = 50;
		int discountQuantity = 3;
		double discountPrice = 130;
		priceRules.add(itemName,unitPrice,discountQuantity,discountPrice);
		Rule rule = priceRules.getRule(itemName);
		assertNotNull(rule);
	}
	
	@Test
	public void testDesignRuleForAnotherItem(){
		String itemName = "A";
		double unitPrice = 50;
		int discountQuantity = 3;
		double discountPrice = 130;
		priceRules.add(itemName,unitPrice,discountQuantity,discountPrice);
		Rule rule = priceRules.getRule(itemName);
		assertTrue("A".equals(rule.getItemName()));
		assertTrue(50 == rule.getUnitPrice());
		assertTrue(3 == rule.getDiscountQuantity());
		assertTrue(130 == rule.getDiscountPrice());
	}
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		priceRules = new PriceRules();
	}

	@After
	public void tearDown() throws Exception {
		priceRules = null;
	}

	@Test
	public void testSetup() {
		assertNotNull(priceRules);
	}

}
