package com.techelevator.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogWriter implements Writer {

	private File logFile;
	
	public LogWriter(File logFile) {
		this.logFile = logFile;
	}
	
	@Override
	public void write(List<String> lines) throws IOException {
		
		try ( PrintWriter printWriter = new PrintWriter(logFile);
				BufferedWriter buffWriter = new BufferedWriter(printWriter) ){
			
			for (String line : lines) {
				
				buffWriter.append(getDateAndTime() + line + "\n");
				
			}
		}
		
		
	}
	
	private String getDateAndTime() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss aa");
		LocalDateTime now = LocalDateTime.now();
		
		return dtf.format(now);
	}

}
