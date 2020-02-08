package com.techelevator.transactions;

import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.items.Beverage;
import com.techelevator.items.Dessert;
import com.techelevator.items.Item;


public class CartTest {

	private Cart cart;
	private Item item;
	private Item item2;
	
	@Before
	public void setup() {
		cart = new Cart();
		item = new Dessert("Pie", 245, "C4");
		item2 = new Beverage("Beer", 546,"B3");
	}
	
	@Test
	public void if_item_is_null_nothing_added_to_cart() {
		
		cart.addItem(null, 2);
		Assert.assertTrue(cart.getCart().isEmpty());
		
	}
	
	@Test
	public void if_quantity_is_negative_nothing_added_to_cart() {
		
		cart.addItem(item, -2);
		Assert.assertTrue(cart.getCart().isEmpty());
		
	}
	
	@Test
	public void if_quantity_is_zero_nothing_added_to_cart() {
		
		cart.addItem(item, 0);
		Assert.assertTrue(cart.getCart().isEmpty());
		
	}
	
	@Test
	public void quantity_is_10_if_10_items_added_to_empty_cart() {
		
		cart.addItem(item, 10);
		Assert.assertEquals(10, (int)cart.getCart().get(item));
		
	}
	
	@Test
	public void quantity_is_20_if_10_items_added_to_10_item_cart() {
		
		cart.addItem(item, 10);
		cart.addItem(item, 10);
		Assert.assertEquals(20, (int)cart.getCart().get(item));
		
	}
	
	@Test
	public void returns_cost_of_item_added_to_cart_for_balance() {
		
		cart.addItem(item, 3);
		Assert.assertEquals(245*3, cart.getBalance());
		
	}
	
	@Test
	public void returns_correct_balance_for_multiple_items_in_cart() {
		
		cart.addItem(item, 5);
		cart.addItem(item2, 3);
		Assert.assertEquals((245*5 + 546*3), cart.getBalance());
		
	}
	
	@Test
	public void return_balance_is_zero_for_empty_cart() {
		
			Assert.assertEquals(0, cart.getBalance());
			
	}
	
}
