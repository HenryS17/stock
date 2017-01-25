package com.henry.stock;

import java.io.IOException;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class TestReadSp500 {
	@Test
	public void test() {
		try {
			File file = new File("C:\\Users\\Henry\\workspace\\Finance\\stock\\src\\com\\henry\\stock\\constituents.json");
			FileInputStream fis = new FileInputStream(file);
			ReadList reader = new ReadList();
			SpStockData[] stocks = reader.readFile(fis);
		}
		catch(IOException exception) {
			fail();
		}
	}
}
