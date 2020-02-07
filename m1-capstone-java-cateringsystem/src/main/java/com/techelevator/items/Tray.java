package com.techelevator.items;

public class Tray {
	
	private int count = 50;
	private Item item;
	
	public Tray(Item item) {
		this.item = item;
	}
	
	public int getCount() {
		return count;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int removeItem(int numberOfItems) {
		
		return count-=numberOfItems;
		
	}
}
