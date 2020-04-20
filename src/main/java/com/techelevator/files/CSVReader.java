package com.techelevator.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.items.Appetizer;
import com.techelevator.items.Beverage;
import com.techelevator.items.Dessert;
import com.techelevator.items.Entree;
import com.techelevator.items.Item;
import com.techelevator.items.Tray;

public class CSVReader implements Reader {

	private String filename;
	
	public CSVReader(String filename) {
		this.filename = filename;
	}
	
	private List<String> read() throws FileNotFoundException {
		
		List<String> lines = new ArrayList<String>();
		
		try(Scanner fileScanner = new Scanner(getFile(filename))){
			
			while (fileScanner.hasNextLine()) {
				
				String line = fileScanner.nextLine();
				lines.add(line);
				
			}
			
		}

		return lines;
	}

	@Override
	public Map<String, Tray> load() throws FileNotFoundException {
		
		List<String> lines = read();
		Map<String, Tray> inventoryMap = new LinkedHashMap<String, Tray>();
		
		for (String line : lines) {
			
			String[] chunks = line.split("\\|");
			
			Tray tray = createTray(chunks);
			
			inventoryMap.put(chunks[0], tray);
		}
		
		return inventoryMap;
	}
	
	private Tray createTray(String[] chunks) {
		
		Tray tray = null;
		String productCode = chunks[0];
		String name = chunks[1];
		int price = (int) (100*Double.parseDouble(chunks[2]));
		String type = chunks[3];
		Item item = null; 
		
		switch(type) {
		case "B":
			item = new Beverage(name, price, productCode);
			break;
		case "A":
			item = new Appetizer(name, price, productCode);
			break;
		case "D":
			item = new Dessert(name, price, productCode);
			break;
		case "E":
			item = new Entree(name, price, productCode);
			break;
		}
		
		tray = new Tray(item);
		
		return tray;
	}
	
	private File getFile(String filename) {

		File file = new File(filename);
		return file;
	}

}
