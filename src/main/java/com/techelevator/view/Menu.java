package com.techelevator.view;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.items.*;
import com.techelevator.items.Appetizer;
import com.techelevator.items.Beverage;
import com.techelevator.items.Dessert;
import com.techelevator.items.Entree;
import com.techelevator.transactions.Account;
import com.techelevator.transactions.Cart;

public class Menu {

	Scanner scanner = new Scanner(System.in);

	public int displayMainMenu() {
		System.out.println("Main Menu");
		System.out.println("============================================================");
		System.out.println("1) Display Catering Items");
		System.out.println("2) Order");
		System.out.println("3) Quit");
		
		return getUserChoice();
	}

	public int displayPurchaseMenu(double balance) {
		System.out.println("\nPurchase Menu");
		System.out.println("============================================================");
		System.out.println("1) Add Money");
		System.out.println("2) Select Products");
		System.out.println("3) Complete Transaction");
		System.out.printf("Current Account Balance: $%-1.2f\n", balance/100.);
		
		return getUserChoice();

	}
	

	public void displayCateringMenu(Map<String, Tray> inventory) {
		System.out.printf("%20s", "Catering Menu\n");
		System.out.println("============================================================");
		System.out.printf("%-3s %-15s %-24s %-8s\n", "ID", "Category", "Item", "Price");
		System.out.println("------------------------------------------------------------");
		for (Entry entry : inventory.entrySet()) {
			String id = (String) entry.getKey();
			String name = (String) ((Item) ((Tray)entry.getValue()).getItem()).getName();
			String type = checkItemType((Item) ((Tray)entry.getValue()).getItem());
			double price = ((Item) ((Tray)entry.getValue()).getItem()).getPriceInCents() / 100.;
			System.out.printf("%-3s %-15s %-24s $%-8.2f\n", id, type, name, price);

		}
		System.out.println();
	}

	public void displayReport(Cart cart) {
		System.out.printf("%-3s %-15s %-24s %-8s %-7s\n", "#", "Category", "Item", "Price", "Total");
		System.out.println("-------------------------------------------------------------");
		for (Entry item : cart.getCart().entrySet()) {
			int quantity = (int) item.getValue();
			String type = checkItemType((Item) item.getKey());
			String name = ((Item) item.getKey()).getName();
			double costPerItem = ((Item) item.getKey()).getPriceInCents() / 100.;
			double totalCost = costPerItem * quantity;

			System.out.printf("%-3d %-15s %-24s $%-7.2f $%-7.2f\n", quantity, type, name, costPerItem, totalCost);
		}
		System.out.printf("\nTotal: $%-7.2f\n\n", cart.getBalance()/100.);
	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayChange(Map<String, Integer> changeMap) {
		System.out.print("\n\nHere's your change: ");
		for (Entry denomination : changeMap.entrySet()) {
			if ((int) denomination.getValue() != 0) {
				System.out.print(denomination.getValue() + " " + denomination.getKey() + "  ");
			}
		}
		System.out.println("\n\nHave a nice day!\n");
	}

	public double askUserForDeposit(Account account) {
		
		String userInput = "";
		int amountToDeposit = 0;
		while (true) {
			System.out.println("How much would you like to deposit?\n");
			userInput = scanner.nextLine();
			if (userInput.matches("\\d+")) {
				amountToDeposit = Integer.parseInt(userInput) * 100;
				break;
			} else {
				System.out.println("\nThe number you entered is not a whole number. Try again.\n");
			}

		}
		try {
			account.deposit(amountToDeposit);
		} catch (Exception e) {
			displayMessage(e.getMessage());
		}
		return amountToDeposit/100.;
	}

	public String askUserForProductCode(Map<String, Tray> inventory) {
		String productCode = "";
		while (true) {
			System.out.println("\nSelect Product ID: ");
			productCode = scanner.nextLine();
			if (inventory.containsKey(productCode)) {
				return productCode;
			} else {
				System.out.println("You typed an Invalid Product ID.");
			}
		}
	}

	public int askUserForQuantity(String productName) {
		
		String userInput = "";
		int quantity = 0;
		while (true) {
			System.out.println("\nHow many " + productName + " would you like to add?");
			userInput = scanner.nextLine();
			if (userInput.matches("\\d+")) {
				quantity = Integer.parseInt(userInput);
				break;
			} else {
				System.out.println("The amount you entered was not a whole number. Please try again.");
			}

		}
		return quantity;
	}

	private int getUserChoice() {
		String userInput = "";
		int userChoice = 0;
		
		while (true) {
			userInput = scanner.nextLine();
			if (userInput.matches("[1-3]")) {
				userChoice = Integer.parseInt(userInput);
				break;
			} else {
				System.out.println("\nInvalid Option. Try Again. \n");
			}

		}
		return userChoice;
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
