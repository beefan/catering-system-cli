package com.techelevator.items;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	
	@Before
	public void setup() {
		item = new Item("Roll", 102, "A2");
	}
	
	@Test
	public void returns_roll_for_name() {
		Assert.assertEquals("Roll", item.getName());
	}
	
	@Test
	public void returns_102_for_price() {
		Assert.assertEquals(102, item.getPriceInCents());
	}
	
	@Test
	public void returns_A2_for_product_code() {
		Assert.assertEquals("A2", item.getProductCode());
	}
}
