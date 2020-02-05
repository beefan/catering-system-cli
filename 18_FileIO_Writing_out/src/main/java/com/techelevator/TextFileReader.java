package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader implements FileReader {

	private File sourceFile;
	
	public TextFileReader(File sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	@Override
	public List<String> read() throws FileNotFoundException {
		
		List<String> bookLines = new ArrayList<String>();
		
		try (Scanner fileScanner = new Scanner(this.sourceFile)) {
			
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				bookLines.add(line);
			}
		}
		return bookLines;
	}

}
