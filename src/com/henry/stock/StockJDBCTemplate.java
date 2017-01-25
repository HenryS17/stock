package com.henry.stock;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StockJDBCTemplate implements DataDao {
	private static final Logger LOGGER = Logger.getLogger(StockJDBCTemplate.class.getName());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	// Insert a new record
	public void create(String name, float value) {
		 String SQL = "insert into stock (name, value) values (?, ?)";
		 jdbcTemplateObject.update( SQL, name, value);
	}
   
	
	// Reset all records, remove current data from DB, and read SP 500 list file and get their data and fill DB.
	// The data is the beginning of current year.
	@Override	
	public void reset() {
		// remove all data
		String deleteAllSQL = "delete * from stock";
	    jdbcTemplateObject.update(deleteAllSQL);
		Calendar beginOfYear = Calendar.getInstance();
		
		// We use the data from the first day (actually the price of market close of previous year).new year day
		// market is closed.
		beginOfYear.MONTH = Calendar.JANUARY;
		beginOfYear.DAY_OF_MONTH = 1;
		
	    // Add new records
		InputStream in = getClass().getResourceAsStream("/constituents.json");  
	    ReadList readList = new ReadList();
	    
	    try {
	    	int count = 20; // 20 records every time
	    	SpStockData[] stockList = readList.readFile();	
	    	SpStockDataImporter importer = new SpStockDataImporter();
	    	int i = 0;
	    	String[] symbols = new String[count];
	    	String[] sectors = new String[count];
	    	
	    	for (SpStockData stock : stockList) {
	    		symbols[i] = stock.getSymbol();
	    		sectors[i] = stock.getSector();
	    		
	    		if (i == (count -1)) {
	    			List<StockData> stockDatas = importer.getStocks(symbols, beginOfYear, beginOfYear);
	    			
	    			for (stockData : stockDatas) {
				    	create(stock.getName(), stock.getValue());	
	    			}
			    	i = -1;
	    		}
		    	++i;
		    }
	    
	    }
	    catch (IOException e) {
	    	LOGGER.log(Level.SEVERE, "Failure to read file or data");
	    	LOGGER.log(Level.INFO, e.toString());
	    }
	    
	    
	}
	
	public void upateAll() {
		
	}
	
		
}
