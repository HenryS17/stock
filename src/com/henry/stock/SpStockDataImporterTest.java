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
			Calendar from = Calendar.getInstance();
			from.add(Calendar.YEAR, -1);
			from.set(Calendar.MONTH, Calendar.DECEMBER);
			from.set(Calendar.DAY_OF_MONTH, 29);
			Calendar to = Calendar.getInstance();
			to.set(Calendar.MONTH, Calendar.JANUARY);
			to.set(Calendar.DAY_OF_MONTH, 1);
			
			SpStockDataImporter importer = new SpStockDataImporter();
			
			StockData data1 = importer.getYearBegings("FB", from, to);
			StockData data2 = importer.getYearBegings("GOOG", from, to);
			StockData data3 = importer.getYearBegings("DIS", from, to);
			
			assertTrue(data1.getPrice() == 115.05);
			assertTrue(data1.getName() == "Facebook, Inc.");
			assertTrue(data2.getPrice() == 771.82	);
			assertTrue(data2.getName() == "Alphabet Inc.");
			assertTrue(data3.getPrice() == 104.22);
			assertTrue(data3.getName() == "The Walt Disney Company");
		}	
		catch(Exception exception) {
			fail();
		}
	}
}
