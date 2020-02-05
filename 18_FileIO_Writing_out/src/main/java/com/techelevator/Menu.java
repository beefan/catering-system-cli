package com.techelevator;

import java.util.Scanner;

public class Menu {

	private Scanner in = new Scanner(System.in);
	
	public String getWordFromUser() {
		System.out.println("Choose a search word >>> ");
		return in.nextLine();
	}
	
	public String getReplaceWordFromUser() {
		System.out.println("Now, choose a word to replace that word >>> ");
		return in.nextLine();
	}
	
	public String getPathFromUser(String fileType) {
		System.out.println("Type path to " + fileType + " file >>> ");
		return in.nextLine();
	}
	
	public void displayMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}
}
