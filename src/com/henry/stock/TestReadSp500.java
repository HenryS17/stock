package com.henry.stock;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;


public class TestReadSp500 {
	@Test
	public void test() {
		try {
			File file = new File("D:\\Users\\Henry\\My Code\\stock\\src\\com\\henry\\stock\\constituents.json");
			FileInputStream fis = new FileInputStream(file);
			ReadList reader = new ReadList();
			SpStockData[] stocks = reader.readFile(fis);
			
			assertTrue(stocks.length >= 500);
		}
		catch(IOException exception) {
			fail();
		}
	}
}
