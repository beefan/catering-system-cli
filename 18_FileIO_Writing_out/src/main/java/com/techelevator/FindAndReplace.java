package com.techelevator;

import java.io.File;
import java.io.IOException;

public class FindAndReplace {

	private Menu menu = new Menu();
	
	public void run() {
		
		//prompt user for search word
		String searchWord = menu.getWordFromUser();
		
		//prompt user for word to replace
		String replaceWord = menu.getReplaceWordFromUser();
		
		//prompt user for source file
		File sourceFile = getFile("source");
		
		//prompt user for destination file
		File destinationFile = getFile("destination");
		
		//replace the word
		ReplaceWord replace = new ReplaceWord(sourceFile, destinationFile, searchWord, replaceWord);
		
		try {
			replace.findAndReplace();
		} catch (IOException e) {
			menu.displayMessage("Issues reading file: " + e.getMessage());
		}
		
	}
	
	private File getFile(String fileType) {
		
		File file = null;
		while (file == null) {
			String filename = menu.getPathFromUser(fileType);
			file = new File(filename);
			
			if ((!file.exists() || !file.isFile()) && fileType.equals("source")) {
				menu.displayMessage(filename + " is not valid. ");
				System.exit(0);
			}
		}
		
		return file;
		
	}
	
	public static void main(String[] args) {

		FindAndReplace main = new FindAndReplace();
		main.run();
		
	}

}
