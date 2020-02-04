package com.techelevator;

import java.io.File;
import java.util.Scanner;


public class WordCountMenu {

	
	public File getFileFromUser() {
		File file;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's the path of the file?");
		
		String filePath = scanner.nextLine();
		file = new File(filePath);
		return file;
	}
	
	public void printWordCount(int wordCount) {
		System.out.println("Word Count: " + wordCount);
	}
	
	public void printSentenceCount(int sentenceCount) {
		System.out.println("Sentence Count: " + sentenceCount);
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
}
