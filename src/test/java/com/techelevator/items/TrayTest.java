package com.techelevator.items;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrayTest {

	private Tray tray;

	@Before
	public void setup() {

		Item item = new Entree("Pizza", 305, "B7");
		tray = new Tray(item);

	}

	@Test
	public void returns_initial_count_50() {
		
		Assert.assertEquals(50, tray.getCount());
		
	}
	
	@Test
	public void returns_item_from_constructor() {
		
		Item item = new Entree("Pizza", 305, "B7");
		Assert.assertEquals(item.getName(), tray.getItem().getName());
		Assert.assertEquals(item.getPriceInCents(), tray.getItem().getPriceInCents());
		Assert.assertEquals(item.getProductCode(), tray.getItem().getProductCode());
		
	}
	
	@Test
	public void returns_48_items_when_2_are_removed() {
		try {
			tray.removeItem(2);
		} catch (Exception e) {
			Assert.fail("Removed too many items from tray");
		}
		Assert.assertEquals(48, tray.getCount());
		
	}
}
