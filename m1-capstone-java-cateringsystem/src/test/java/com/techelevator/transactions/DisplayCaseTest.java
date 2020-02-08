package com.techelevator.transactions;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.items.Dessert;

public class DisplayCaseTest {

	private static final String TEST_CSV_FILE = "cateringsystem.csv";
	private DisplayCase displayCase;
	private Account account;

	@Before
	public void setup() {
		try {
			displayCase = new DisplayCase(TEST_CSV_FILE);
		} catch (FileNotFoundException e) {
			Assert.fail("Test failed: " + e.getMessage());
		}
		account = new Account();
		try {
			account.deposit(750);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			displayCase.addToCart(new Dessert("pie", 234, "A6"), 1, account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void get_inventory_returns_data_from_file() {

		Assert.assertEquals(18, displayCase.getInventory().size());

	}

	@Test
	public void items_get_added_to_cart() {
		Cart cart = displayCase.getCart();

		Assert.assertEquals(234, cart.getBalance());

	}

	@Test
	public void account_balance_changes_after_adding_item_to_cart() {
		Assert.assertEquals(750 - 234, account.getBalance());
	}

}
