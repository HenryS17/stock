package com.henry.stock;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
	public SpStockData[] readFile(InputStream fis) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		SpStockData[] array = objectMapper.readValue(fis, SpStockData[].class);
		
		LOGGER.log(Level.INFO, "Total SP 500 number of read is " + Integer.toString(array.length));
		
		return array;
	}
}
