package com.henry.stock;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.stock.StockQuote;
import yahoofinance.quotes.stock.StockStats;

// APIs from http://financequotes-api.com/
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
				Stock stock = item.getValue();
				
				stockToStockData(item.getKey(), stock, stockData);	
				stockData.setPrice(stock.getQuote().getPreviousClose().setScale(2, RoundingMode.HALF_UP).doubleValue());
				list.add(stockData);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	
	/**
	 * Get the last year's close stock prices and other informations
	 * @param symbols: symbols of the stocks.
	 * @return stock data
	 */
	public List<StockData> getYearBegings(String[] symbols) {
		List<StockData> list = new ArrayList<>();
		
		Calendar from = Calendar.getInstance();
		from.add(Calendar.YEAR, -1);
		from.set(Calendar.MONTH, Calendar.DECEMBER);
		from.set(Calendar.DAY_OF_MONTH, 29);
		Calendar to = Calendar.getInstance();
		to.set(Calendar.MONTH, Calendar.JANUARY);
		to.set(Calendar.DAY_OF_MONTH, 1);
		
		try {
			Map<String, Stock> stocks = YahooFinance.get(symbols, from, to, Interval.DAILY); 
//			Stock stock = YahooFinance.get("FB", true); 
//			List<HistoricalQuote> history = stock.getHistory();
			for (Map.Entry<String, Stock> item : stocks.entrySet()){
				StockData stockData = new StockData();
				List<HistoricalQuote> histyQuotes = item.getValue().getHistory();
				
				stockToStockData(item.getKey(), item.getValue(), stockData);
				stockData.setPrice(histyQuotes.get(0).getClose().setScale(2, RoundingMode.HALF_UP).doubleValue());
				list.add(stockData);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	private void stockToStockData(String symbol, Stock stock, StockData stockData) {
		StockQuote stockQuote = stock.getQuote();
		StockStats stockStats = stock.getStats();
		
		stockData.setName(stock.getName());				
		stockData.setSymbol(symbol);
		stockData.setPe(stockStats.getPe().doubleValue());
		stockData.setPeg(stockStats.getPeg().doubleValue());
		stockData.setEps(stockStats.getEps().doubleValue());
		stockData.setRoe(stockStats.getROE().doubleValue());
		stockData.setPriceToBook(stockStats.getPriceBook().doubleValue());
		stockData.setPriceToSale(stockStats.getPriceSales().doubleValue());
		stockData.setVolumn(stockQuote.getVolume());
		stockData.setOneYearTarget(stockStats.getOneYearTargetPrice().setScale(2, RoundingMode.HALF_UP).doubleValue());
	}
}
