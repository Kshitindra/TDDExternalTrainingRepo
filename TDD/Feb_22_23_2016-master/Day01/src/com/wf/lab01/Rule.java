package com.wf.lab01;

public class Rule {
	private String itemName;
	private double unitPrice;
	private int discountQuantity;
	private double discountPrice;
	public Rule(String itemName, double unitPrice, double discountPrice,int discountQuantity) {
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.discountQuantity = discountQuantity;
		this.discountPrice = discountPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public int getDiscountQuantity() {
		return discountQuantity;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	
}
