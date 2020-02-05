package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReplaceWord {

	private File destinationFile;
	private File sourceFile;
	private String searchWord;
	private String replaceWord;

	public ReplaceWord(File sourceFile, File destinationFile, String searchWord, String replaceWord) {
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.searchWord = searchWord;
		this.replaceWord = replaceWord;
		
	}
	
	public void findAndReplace() throws IOException{
		
		FileReader reader = new TextFileReader(sourceFile); 
		
		List<String> bookLines = reader.read();
		
		bookLines = replace(bookLines, searchWord, replaceWord);
		
		FileWriter writer = new TextFileWriter(destinationFile);
		
		writer.write(bookLines);
		
	}
	
	private List<String> replace(List<String> bookLines, String searchWord, String replaceWord) {
		
		List<String> finishedList = new ArrayList<String>();
		
		for ( String line : bookLines) {
			
			finishedList.add(line.replaceAll(searchWord, replaceWord));
		}
		
		return finishedList;
		
	}
	
}

