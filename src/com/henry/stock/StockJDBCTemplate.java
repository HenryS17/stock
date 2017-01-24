package com.henry.stock;

import java.io.IOException;
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
	@Override	
	public void reset() {
		// remove all data
		String deleteAllSQL = "delete * from stock";
	    jdbcTemplateObject.update(deleteAllSQL);
	    
	    // Add new records
	    ReadList readList = new ReadList();
	    SpStockData[] stockList = null;
	    
	    try {
	    	stockList = readList.readFile();	
	    	SpStockDataImporter importer = new SpStockDataImporter();
	    	
	    	
	    	for (SpStockData item : stockList) {
		    	create(item.getName(), item.getValue());
		    }
	    
	    }
	    catch (IOException e) {
	    	LOGGER.log(Level.SEVERE, "Failure to read file");
	    }
	    
	    
	}
	
	public void upateAll() {
		
	}
	
		
}
