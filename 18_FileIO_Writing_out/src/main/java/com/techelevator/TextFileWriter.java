package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TextFileWriter implements FileWriter {

	private File destinationFile;
	
	public TextFileWriter(File destinationFile) {
		this.destinationFile = destinationFile;
	}
	
	@Override
	public void write(List<String> lines) throws IOException {
		
		try( PrintWriter printWriter = new PrintWriter(destinationFile); 
				BufferedWriter bufferedWriter = new BufferedWriter(printWriter) ){
			
			for (String line : lines) {
				bufferedWriter.write(line +"\n");
			}
		}
				
				
		
	}

}
