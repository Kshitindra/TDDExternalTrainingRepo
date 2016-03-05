package com.wf.lab01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceRules {

	private Map<String,Rule> rulesMap = new HashMap();
	public void add(String itemName, double unitPrice, int discountQuantity, double discountPrice) {
		Rule rule = new Rule(itemName,unitPrice,discountPrice,discountQuantity);
		rulesMap.put(itemName,rule);
	}

	public Rule getRule(String itemName) {
		return rulesMap.get(itemName);
	}

}
