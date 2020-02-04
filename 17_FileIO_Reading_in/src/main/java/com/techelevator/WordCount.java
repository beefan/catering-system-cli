package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {

	public void run() {

		WordCountMenu menu = new WordCountMenu();

		File file = menu.getFileFromUser();

		FileReader reader = new TextFileReader(file);

		List<String> text = new ArrayList<String>();

		try {
			text = reader.read();

		} catch (FileNotFoundException e) {
			menu.printMessage("File not Found!");

		}

		int numWords = reader.countWords(text);

		int numSentences = reader.countSentences(text);

		menu.printWordCount(numWords);

		menu.printSentenceCount(numSentences);
	}

	public static void main(String[] args) {

		WordCount wc = new WordCount();
		wc.run();

	}

}
