package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import com.techelevator.files.LogWriter;
import com.techelevator.items.Item;
import com.techelevator.transactions.Account;
import com.techelevator.transactions.DisplayCase;
import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;
	private DisplayCase displayCase;
	private LogWriter logWriter;
	private Account account;
	private DecimalFormat decimalFormatter = new DecimalFormat("#.##");
	private static final String CATERING_SYSTEM_LOAD_FILE = "cateringsystem.csv";
	private static final String LOGFILE = "Log.txt";

	public CateringSystemCLI(Menu menu, DisplayCase displayCase, LogWriter logWriter, Account account) {
		this.menu = menu;
		this.displayCase = displayCase;
		this.logWriter = logWriter;
		this.account = account;
	}

	public void run() {
		while (true) {
			switch (menu.displayMainMenu()) {
			case 1:
				menu.displayCateringMenu(displayCase.getInventory());
				break;
			case 2:
				try {
					runPurchaseMenu();
				} catch (IOException e) {
					menu.displayMessage("Unable to write to " + LOGFILE + ". ");
				}
				break;
			case 3:
				menu.displayMessage("\nThanks for shopping with us! :)");
				System.exit(0);
			}

		}
	}

	private void runPurchaseMenu() throws IOException {
		while (true) {
			switch (menu.displayPurchaseMenu(account.getBalance())) {
			case 1:
				double amountToDeposit = menu.askUserForDeposit(account);
				logWriter.write("ADD MONEY: $" + decimalFormatter.format(amountToDeposit) + " $" + decimalFormatter.format(account.getBalance()/100.)) ;
				break;
			case 2:
				String productCode = menu.askUserForProductCode(displayCase.getInventory());
				Item item = displayCase.getItemFromProductCode(productCode);
				int quantity = menu.askUserForQuantity(item.getName());
				try {
					displayCase.addToCart(item, quantity, account);
				} catch (Exception e) {
					menu.displayMessage(e.getMessage());
				}
				logWriter.write(quantity +" "+ item.getName() + " " + item.getProductCode() + " $" 
						+ decimalFormatter.format(item.getPriceInCents()/100.) + " $" + decimalFormatter.format(item.getPriceInCents()/100.*quantity)) ;
				break;
			case 3:
				int accountBalanceInCents = account.getBalance();
				try {
					menu.displayChange(displayCase.checkOut(account));
					menu.displayReport(displayCase.getCart());
					logWriter.write("GIVE CHANGE: $" + decimalFormatter.format(accountBalanceInCents/100.) + " $"+account.getBalance());
				} catch (Exception e) {
					menu.displayMessage(e.getMessage());
				}
				return;

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		DisplayCase displayCase;
		try {
			displayCase = new DisplayCase(CATERING_SYSTEM_LOAD_FILE);
		} catch (FileNotFoundException e) {
			displayCase = null;
			menu.displayMessage("Sorry. Couldn't load your catering file.");
			System.exit(0);
		}
		LogWriter logWriter = new LogWriter(LOGFILE);
		Account account = new Account();
		CateringSystemCLI cli = new CateringSystemCLI(menu, displayCase, logWriter, account);
		cli.run();
	}
}
