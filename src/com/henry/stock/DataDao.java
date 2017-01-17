package com.henry.stock;

import javax.sql.DataSource;


//import yahoofinance.Stock;
//import yahoofinance.YahooFinance;

// http://financequotes-api.com/
public interface DataDao {
	public void setDataSource(DataSource ds);
//	public List<StockData> getTopTen() {
//		String[] symbols = new String[6];
//		symbols[0] = "FB";
//		symbols[1] = "V";
//		symbols[2] = "GILD";
//		symbols[3] = "TRI";
//		symbols[4] = "VMC";
//		symbols[5] = "KR";
//		return (getStocks(symbols));
//	}
	
//	private List<StockData> getStocks(String[] symbols) {
//		List<StockData> list = new ArrayList<>();
//		
//		
//		try {
//			Map<String, Stock> stocks = YahooFinance.get(symbols); // single request
//			
//			for (Map.Entry<String, Stock> item : stocks.entrySet()){
//				StockData stockData = new StockData();
//				
//				stockData.setSymbol(item.getKey());
//				stockData.setPrice(item.getValue().getQuote().getPrice().floatValue());
//				BigDecimal price = item.getValue().getQuote().getPrice();				
//			}
//		}
//		catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return list;
//	}
	
	public void reset();
}
