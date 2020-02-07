package com.techelevator.transactions;

import java.util.LinkedHashMap;
import java.util.Map;

public class Register {

	private Map<String, Integer> changeMap = new LinkedHashMap<String, Integer>();

	public Map<String, Integer> makeChange(Account account, Cart cart) {
		int changeInCents = account.getBalance() - cart.getBalance();
		getNickels(getDimes(getQuarters(getOnes(getFives(getTens(getTwenties(changeInCents)))))));
		return changeMap;
	}

	private int getTwenties(int change) {
		changeMap.put("Twenties", change / 2000);
		return change % 2000;
	}

	private int getTens(int change) {
		changeMap.put("Tens", change / 1000);
		return change % 1000;

	}

	private int getFives(int change) {
		changeMap.put("Fives", change / 500);
		return change % 500;

	}

	private int getOnes(int change) {
		changeMap.put("Ones", change / 100);
		return change % 100;

	}

	private int getQuarters(int change) {
		changeMap.put("Quarters", change / 25);
		return change % 25;

	}

	private int getDimes(int change) {
		changeMap.put("Dimes", change / 10);
		return change % 10;

	}

	private void getNickels(int change) {
		changeMap.put("Nickels", change / 5);
	}
}
