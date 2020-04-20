package com.techelevator.items;

public class Item {
	
	private String name;
	private int priceInCents;
	private String productCode;
	
	public Item(String name, int priceInCents, String productCode) {
		
		this.name = name;
		this.priceInCents = priceInCents;
		this.productCode = productCode;
		
	}

	public String getName() {
		return name;
	}

	public int getPriceInCents() {
		return priceInCents;
	}

	public String getProductCode() {
		return productCode;
	}
	
}
