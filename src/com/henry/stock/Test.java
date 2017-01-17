package com.henry.stock;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			StockData stock = new StockData();
//			LocalDate date = LocalDate.now();
//			
//			stock.setDate(date);
			stock.setName("Facebook");
//			stock.setPe(1.2f);
//			stock.setPrice(100.1f);
			stock.setSymbol("FB");
			
			String s = stock.toString();
		//	System.out.println(s);
			
			ReadList updateList = new ReadList();
			try {
				SpStockData[] datas = updateList.readFile();
				System.out.println(datas[0].toString());
				System.out.println(datas[1].toString());
				System.out.println(datas[2].toString());
			}
			catch(IOException e) {
				System.out.println(e.toString());
			}
			
			SpStockDataImporter sp = new SpStockDataImporter();
			sp.getTopTen();
			
		}

}
