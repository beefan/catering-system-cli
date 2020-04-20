package com.techelevator.files;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.techelevator.items.Tray;

public interface Reader {

	Map<String, Tray> load() throws FileNotFoundException;
	
}
