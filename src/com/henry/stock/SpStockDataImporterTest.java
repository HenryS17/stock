package com.henry.stock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class SpStockDataImporterTest {
	@Test
	public void test() {
		try {
			String[] symbols = {"FB", "GOOG", "DIS"};		
			
			SpStockDataImporter importer = new SpStockDataImporter();
			
			List<StockData> data = importer.getYearBegings(symbols);
			
			assertTrue(data.get(1).getPrice() == 115.05);
			assertTrue(data.get(1).getName() == "Facebook, Inc.");
			assertTrue(data.get(0).getPrice() == 771.82	);
			assertTrue(data.get(0).getName() == "Alphabet Inc.");
			assertTrue(data.get(2).getPrice() == 104.22);
			assertTrue(data.get(2).getName() == "The Walt Disney Company");
		}	
		catch(Exception exception) {
			fail();
		}
	}
}
