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
		
		try {
			account.deposit(750);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(750, account.getBalance());
		
	}
	
	@Test
	public void return_balance_after_purchase() {
		
		try {
			account.deposit(4000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			account.purchase(2500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(4000-2500, account.getBalance());
	
	}
	
	@Test
	public void return_balance_after_purchase_larger_than_balance() {
		
		try {
			account.deposit(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			account.purchase(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(4000, account.getBalance());
	
	}
	
	@Test
	public void balance_is_zero_at_start() {
		
		Assert.assertEquals(0, account.getBalance());
	
	}
	
	@Test
	public void balance_cant_be_more_than_5000_dollars() {
		
		try {
			account.deposit(6000*100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(0, account.getBalance());
		
	}
	
	
}
