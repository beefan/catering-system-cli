package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader implements FileReader {

	private File file;

	public TextFileReader(File file) {
		this.file = file;
	}

	@Override
	public List<String> read() throws FileNotFoundException {
		Scanner scanner = new Scanner(this.file);
		List<String> text = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			text.add(scanner.nextLine());
		}
		return text;
	}

	public int countWords(List<String> text) {
		int counter = 0;
		for (String line : text) {
			String[] words = line.split("\\s+");
			counter += words.length;
		}
		return counter;

	} //[!?.:]+

	public int countSentences(List<String> text) {
		int counter = 0;
		for (String line : text) {
			String[]sentences = line.split("[!?.:]+");
			counter += sentences.length-1;	
			
		}										
		return counter;
	}
}
