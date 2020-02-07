package com.techelevator.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.items.*;
import com.techelevator.items.Appetizer;
import com.techelevator.items.Beverage;
import com.techelevator.items.Dessert;
import com.techelevator.items.Entree;
import com.techelevator.transactions.Cart;

public class Menu {

	Scanner scanner = new Scanner(System.in);

	public int displayMainMenu() {
		System.out.println("1) Display Catering Items");
		System.out.println("2) Order");
		System.out.println("3) Quit");

		return Integer.valueOf(scanner.nextLine());
	}

	public int displayPurchaseMenu(double balance) {
		System.out.println("1) Add Money");
		System.out.println("2) Select Products");
		System.out.println("3) Complete Transaction");
		System.out.printf("Current Account Balance: $%-1.2f", balance);

		return Integer.valueOf(scanner.nextLine());

	}

	public void displayReport(Cart cart) {
		System.out.printf("%-3s %-15s %-15s %-8s %-7s\n","#", "Category", "Item", "Price", "Total");
		System.out.println("----------------------------------------------------");
		for (Entry item : cart.getCart().entrySet()) {
			int quantity = (int) item.getValue();
			String type = checkItemType((Item)item.getKey());
			String name = ((Item) item.getKey()).getName();
			double costPerItem = ((Item) item.getKey()).getPriceInCents() / 100;
			double totalCost = costPerItem * quantity;

			System.out.printf("%-3d %-15s %-15s $%-7.2f $%-7.2f\n", quantity, type, name, costPerItem, totalCost);
		}
		System.out.printf("\nTotal: $%-7.2f", cart.getBalance());
	}

	
	public void displayMessage(String message) {
		System.out.println(message);
	}
	
	public void displayChange(Map<String, Integer> changeMap) {
		System.out.print("Here's your change: ");
		for( Entry denomination : changeMap.entrySet()) {
			if((int)denomination.getValue()!= 0) {
				System.out.print(denomination.getValue() + " " + denomination.getKey() + "  ");
			}
		}	
		System.out.println("\n\nHave a nice day!\n");
	}
	private String checkItemType(Item item) {
		if (item instanceof Beverage) {
			return "Beverage";
		}

		if (item instanceof Entree) {
			return "Entree";
		}
		if (item instanceof Appetizer) {
			return "Appetizer";

		}
		if (item instanceof Dessert) {
			return "Dessert";
		}
		return "";
	}

}
