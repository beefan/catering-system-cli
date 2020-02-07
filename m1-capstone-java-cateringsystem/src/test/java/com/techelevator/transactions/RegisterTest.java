package com.techelevator.transactions;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.items.Beverage;
import com.techelevator.items.Entree;
import com.techelevator.items.Item;



public class RegisterTest {
	private Register register;
	private Map<String, Integer>changeMap;
	
@Before
public void setup() {
	register = new Register();
	Account account = new Account();
	account.deposit(54555);
	Cart cart = new Cart();
	Item item = new Beverage("Beer", 505, "A3" );
	Item item2 = new Entree("Pizza", 300, "E6");
	cart.addItem(item, 9);
	cart.addItem(item2, 14);
	changeMap = register.makeChange(account, cart);
}

@Test
public void change_map_returns_22_twenties() {
	Assert.assertEquals(22, (int)changeMap.get("Twenties"));
}

@Test
public void change_map_returns_1_ten() {
	Assert.assertEquals(1, (int)changeMap.get("Tens"));
}
@Test
public void change_map_returns_1_five() {
	Assert.assertEquals(1, (int)changeMap.get("Fives"));
}
@Test
public void change_map_returns_3_ones() {
	Assert.assertEquals(3, (int)changeMap.get("Ones"));
}
@Test
public void change_map_returns_0_quarters() {
	Assert.assertEquals(0, (int)changeMap.get("Quarters"));
}
@Test
public void change_map_returns_1_dime() {
	Assert.assertEquals(1, (int)changeMap.get("Dimes"));
}
@Test
public void change_map_returns_0_nickels() {
	Assert.assertEquals(0, (int)changeMap.get("Nickels"));
}
}
