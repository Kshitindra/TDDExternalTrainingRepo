package com.wf.lab01;

import java.util.Iterator;
import java.util.Map;

public class PriceCalculator {

	private PriceRules priceRules;
	public void setPriceRules(PriceRules priceRules) {
		this.priceRules = priceRules;
	}
	public double calculateTotalPrice(Map<String, Integer> items) {
		double total = 0;
		Iterator<String> itemNames = items.keySet().iterator();
		while(itemNames.hasNext()){
			String itemName = itemNames.next();
			Rule rule = priceRules.getRule(itemName);
			int orderedQuantity = items.get(itemName);
			if(rule.getDiscountQuantity() > 0){
				int numberOfDiscountUnits = orderedQuantity/rule.getDiscountQuantity(); // 3/3
				total += numberOfDiscountUnits * rule.getDiscountPrice(); // 1 * 130
				total += (orderedQuantity - 
						(numberOfDiscountUnits * rule.getDiscountQuantity())) * rule.getUnitPrice();
			}
			else{
				total += rule.getUnitPrice() * orderedQuantity;
			}
		}
		return total;
	}

}
