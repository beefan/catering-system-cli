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
	
	public void removeItem(int numberOfItems) throws Exception {
		
		if (count == 0 ){
			throw new Exception("Item is Sold Out. ");
		} else if (count - numberOfItems >= 0) {
			count-=numberOfItems;
		} else {
			throw new Exception("Sorry we only have " + count + " left. Try again. ");
		}
		
	}
}
