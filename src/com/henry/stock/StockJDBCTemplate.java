package com.henry.stock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
		this.dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	// Insert a new record
	public void create(StockData stockData) {
		try {
			 String SQL = "insert into stock (Symbol, Name, Price, PE, PEG, PriceToBook, ROE, EPS, PRiceToSale, Volumn, Sector, OneYearTarget) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 jdbcTemplateObject.update( SQL, stockData.getSymbol(), stockData.getName(), stockData.getPrice(), stockData.getPe(),
					 stockData.getPeg(), stockData.getPriceToBook(), stockData.getRoe(), stockData.getEps(), stockData.getPriceToSale(),
					 stockData.getVolumn(), stockData.getSector(), stockData.getOneYearTarget());	
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
   
	
	// Reset all records, remove current data from DB, and read SP 500 list file and get their data and fill DB.
	// The data is the beginning of current year.
	@Override	
	public void reset() {
		// remove all data
		String deleteAllSQL = "delete from stock";
	    jdbcTemplateObject.update(deleteAllSQL);
		Calendar beginOfYear = Calendar.getInstance();
		
		// We use the data from the first day (actually the price of market close of previous year).new year day
		// market is closed.
		beginOfYear.set(Calendar.MONTH, Calendar.JANUARY);
		beginOfYear.set(Calendar.DAY_OF_MONTH, 1);
		
	    // Add new records		
	    
	    try {
	    	int count = 20; // 20 records every time
	    	
	    	File file = new File("d:\\users\\henry\\My Code\\stock\\src\\com\\henry\\stock\\constituents.json");
			FileInputStream is = new FileInputStream(file);
//			InputStream is = getClass().getResourceAsStream("/constituents.json");  
		    ReadList readList = new ReadList();
		    
	    	SpStockData[] stockList = readList.readFile(is);	
	    	SpStockDataImporter importer = new SpStockDataImporter();
	    	int i = 0;
	    	String[] symbols = new String[count];
	    	String[] sectors = new String[count];
	    	
	    	for (SpStockData stock : stockList) {
	    		symbols[i] = stock.getSymbol();
	    		sectors[i] = stock.getSector();
	    		
	    		if (i == (count -1)) {
	    			List<StockData> stockDatas = importer.getYearBegings(symbols);
	    			
	    			for (StockData stockData : stockDatas) {
	    				fillSector(stockList, stockData);
				    	create(stockData);	
	    			}
			    	i = -1;
	    		}
		    	++i;
		    }
	    
	    }
	    catch (FileNotFoundException fe) {	    
	    	LOGGER.log(Level.SEVERE, "File not found");
	    	LOGGER.log(Level.INFO, fe.toString());
	    }
	    catch (IOException e) {
	    	LOGGER.log(Level.SEVERE, "Failure to read file or data");
	    	LOGGER.log(Level.INFO, e.toString());
	    }
	    
	    
	}
	
	private void fillSector(SpStockData[] stockList, StockData stockData) {
		for (SpStockData spStockData : stockList) {
			if (stockData.getSymbol().equals(spStockData.getSymbol())) {
				stockData.setSector(spStockData.getSector());
			}
		}
	}
	public void updateAll() {
		
	}
	
		
}
