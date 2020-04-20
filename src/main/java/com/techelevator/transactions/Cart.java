package com.techelevator.transactions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.items.Item;

public class Cart {

	private Map<Item, Integer> cartMap = new LinkedHashMap<Item, Integer>();
	
	public Cart( ) {
		
	}
	
	public void addItem(Item item, int quantity) {
		
		if (item == null || quantity < 1 ) {
			return;
		}
		
		if (cartMap.containsKey(item)) {
			
			cartMap.replace(item, cartMap.get(item) + quantity);
			
		} else {
			
			cartMap.put(item, quantity);
			
		}
		
	}
	
	public int getBalance() {
		
		int balance = 0;
		
		for (Entry entry : cartMap.entrySet()) {
			
			balance+= ((Item)entry.getKey()).getPriceInCents() * (int)entry.getValue();
		
		}
		
		return balance;
	}
	
	public Map<Item, Integer> getCart(){
		return this.cartMap;
	}
	
	
}
