package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {
	
	List<String> read() throws FileNotFoundException;

	int countWords(List<String> text);
	
	int countSentences(List<String> text);

}
