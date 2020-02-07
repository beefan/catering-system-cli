package com.techelevator.transactions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account account;
	
	@Before
	public void setup() {
		account = new Account();
	}
	
	@Test
	public void return_balance_after_deposit() {
		
		account.deposit(750);
		Assert.assertEquals(750, account.getBalance());
		
	}
	
	@Test
	public void return_balance_after_purchase() {
		
		account.deposit(4000);
		account.purchase(2500);
		Assert.assertEquals(4000-2500, account.getBalance());
	
	}
	
	@Test
	public void return_balance_after_purchase_larger_than_balance() {
		
		account.deposit(4000);
		account.purchase(5000);
		Assert.assertEquals(4000, account.getBalance());
	
	}
	
	@Test
	public void balance_is_zero_at_start() {
		
		Assert.assertEquals(0, account.getBalance());
	
	}
	
	@Test
	public void balance_cant_be_more_than_5000_dollars() {
		
		account.deposit(6000*100);
		Assert.assertEquals(0, account.getBalance());
		
	}
	
	
}
