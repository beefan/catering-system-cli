package com.techelevator.transactions;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.files.CSVReader;
import com.techelevator.files.Reader;
import com.techelevator.items.Item;
import com.techelevator.items.Tray;

public class DisplayCase {

	private Map<String, Tray> inventory = new LinkedHashMap<String, Tray>();
	private Cart cart = new Cart();

	public DisplayCase(String filename) throws FileNotFoundException {

		Reader reader = new CSVReader(filename);
		this.inventory = reader.load();

	}

	public Map<String, Tray> getInventory() {
		return this.inventory;
	}

	public void addToCart(Item item, int quantity, Account account) throws Exception {
		( (Tray) inventory.get( item.getProductCode() )).removeItem(quantity);
		cart.addItem(item, quantity);
		account.purchase(getCostOfNewCartAddition(item, quantity));

	}

	public Cart getCart() {

		return this.cart;

	}

	public Map<String, Integer> checkOut(Account account) throws Exception {
		Register register = new Register();
		Map<String, Integer> changeMap = register.makeChange(account, this.cart);
		account.purchase(account.getBalance());
		return changeMap;
	}

	public Item getItemFromProductCode(String productCode) {
		return ((Tray) inventory.get(productCode)).getItem();
	}

	private int getCostOfNewCartAddition(Item item, int quantity) {
		return item.getPriceInCents() * quantity;
	}
}
