package com.henry.stock;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

// API from http://financequotes-api.com/
public class SpStockDataImporter {

	public List<StockData> getTopTen() {
		String[] symbols = new String[6];
		symbols[0] = "FB";
		symbols[1] = "V";
		symbols[2] = "GILD";
		symbols[3] = "TRI";
		symbols[4] = "VMC";
		symbols[5] = "KR";
		return (getStocks(symbols));
	}
	
	public List<StockData> getStocks(String[] symbols) {
		List<StockData> list = new ArrayList<>();
		
		try {
			Map<String, Stock> stocks = YahooFinance.get(symbols); 
			
			for (Map.Entry<String, Stock> item : stocks.entrySet()){
				StockData stockData = new StockData();
				
				stockData.setSymbol(item.getKey());
				//stockData.setPrice(item.getValue().getQuote().getPrice().floatValue());
				BigDecimal price = item.getValue().getQuote().getPrice();				
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public List<StockData> getStocks(String[] symbols, Calendar from, Calendar to) {
		List<StockData> list = new ArrayList<>();
		
		try {
			Map<String, Stock> stocks = YahooFinance.get(symbols, from, to); 
			
			for (Map.Entry<String, Stock> item : stocks.entrySet()){
				StockData stockData = new StockData();
				
				stockData.setSymbol(item.getKey());
				//stockData.setPrice(item.getValue().getQuote().getPrice().floatValue());
				BigDecimal price = item.getValue().getQuote().getPrice();				
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
