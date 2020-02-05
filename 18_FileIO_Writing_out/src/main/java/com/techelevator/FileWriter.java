package com.techelevator;

import java.io.IOException;
import java.util.List;

public interface FileWriter {

	void write(List<String> lines) throws IOException;
}
