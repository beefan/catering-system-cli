package com.techelevator.transactions;

public class Account {

		private int balanceInCents = 0;
		
		public Account( ) {
			
		}
		
		public int deposit(int depositInCents) {
			
			if (balanceInCents + depositInCents > 5000*100) {
				
				return balanceInCents;
				
			}
			
			return balanceInCents+=depositInCents;
			
		}
		
		public int purchase(int purchaseInCents) {
			
			if (balanceInCents - purchaseInCents < 0) {
				
				return balanceInCents;
				
			}
			
			return balanceInCents-=purchaseInCents;
			
		}
		
		public int getBalance() {
			
			return balanceInCents;
			
		}
		
}
