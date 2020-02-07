package com.techelevator.view;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.items.Beverage;
import com.techelevator.items.Entree;
import com.techelevator.items.Item;
import com.techelevator.transactions.Cart;

public class MenuTest {
	
	private Menu menu;
	private Cart cart;
	private Item item1;
	private Item item2;
	
	@Before
	public void setup() {
		menu = new Menu();
		
	}
	
	@Test
	public void correctly_prints_report() {
		cart = new Cart();
		item1 = new Entree("Pizza", 302, "A2");
		item2 = new Beverage("Beer", 504, "B1");
		cart.addItem(item1, 10);
		cart.addItem(item2, 12);
		
		menu.displayReport(cart);
	}
	
	@Test
	public void correctly_prints_change() {
		Map<String, Integer> changeMap = new LinkedHashMap();
		changeMap.put("Twenties", 3);
		changeMap.put("Tens", 0);
		changeMap.put("Fives", 1);
		changeMap.put("Ones", 1);
		changeMap.put("Quarters", 6);
		changeMap.put("Dimes", 0);
		changeMap.put("Nickels", 10);
		
		menu.displayChange(changeMap);
	
	}
}
