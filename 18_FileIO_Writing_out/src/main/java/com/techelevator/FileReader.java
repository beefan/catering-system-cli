package com.techelevator;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {

	List<String> read() throws FileNotFoundException;
}
