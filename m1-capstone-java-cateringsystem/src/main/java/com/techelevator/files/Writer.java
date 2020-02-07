package com.techelevator.files;

import java.io.IOException;
import java.util.List;

public interface Writer {
	
	void write(List<String> lines) throws IOException;
	
}
