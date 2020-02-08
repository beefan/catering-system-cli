package com.techelevator.transactions;

public class Account {

		private int balanceInCents = 0;
		
		public Account( ) {
			
		}
		
		public int deposit(int depositInCents) throws Exception {
			
			if (balanceInCents + depositInCents > 5000*100) {
				
				throw new Exception("Your balance cannot exceed $5000.00");
				
			}
			
			return balanceInCents+=depositInCents;
			
		}
		
		public int purchase(int purchaseInCents) throws Exception {
			
			if (balanceInCents - purchaseInCents < 0) {
				
				throw new Exception("You don't have enough money for that.");
				
			}
			
			return balanceInCents-=purchaseInCents;
			
		}
		
		public int getBalance() {
			
			return balanceInCents;
			
		}
		
}
