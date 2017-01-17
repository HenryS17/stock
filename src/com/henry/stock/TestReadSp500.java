package com.henry.stock;

import java.io.IOException;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class TestReadSp500 {
	@Test
	public void test() {
		try {
			ReadList reader = new ReadList();
			SpStockData[] stocks = reader.readFile();
		}
		catch(IOException exception) {
			fails();
		}
	}
}
