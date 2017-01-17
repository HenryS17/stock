package com.henry.stock;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ReadList implements reading constituents.json file to get the SP 500 list.
 * @author Henry
 *
 */
public class ReadList {
	private static final Logger LOGGER = Logger.getLogger(ReadList.class.getName());
	public ReadList() {
		
	}
	public SpStockData[] readFile() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
	//	SpStockData[] array = objectMapper.readValue(new File("C:\\Users\\Henry\\workspace\\Finance\\stock\\src\\com\\henry\\stock\\constituents - Copy.json"), SpStockData[].class);
		SpStockData[] array = objectMapper.readValue(new File("constituents.json"), SpStockData[].class);
		
		LOGGER.log(Level.INFO, "Total SP 500 number of read is " + Integer.toString(array.length));
		
		return array;
	}
}
