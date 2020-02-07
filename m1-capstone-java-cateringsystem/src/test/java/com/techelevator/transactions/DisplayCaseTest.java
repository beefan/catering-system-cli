package com.techelevator.transactions;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.items.Dessert;

public class DisplayCaseTest {
	
	private static final String TEST_CSV_FILE = "cateringsystem.csv";
	private DisplayCase displayCase;
	
	@Before
	public void setup() {
		try {
			displayCase = new DisplayCase(TEST_CSV_FILE);
		} catch (FileNotFoundException e) {
			Assert.fail("Test failed: " + e.getMessage());
		}
	}
	
	@Test
	public void get_inventory_returns_data_from_file() {
		
		Assert.assertEquals(18, displayCase.getInventory().size());
		
	}
	
	@Test
	public void items_get_added_to_cart() {
		
		displayCase.addToCart(new Dessert("pie", 234, "A6"), 1);
		Cart cart = displayCase.getCart();
		
		Assert.assertEquals(2.34, cart.getBalance(), 2);
		
	}
	
}
