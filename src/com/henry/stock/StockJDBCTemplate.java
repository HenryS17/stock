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

import yahoofinance.Stock;

public class StockJDBCTemplate implements DataDao {
	private static final Logger LOGGER = Logger.getLogger(StockJDBCTemplate.class.getName());
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJDBCTempalte() {
		return jdbcTemplateObject;
	}
	
	// Insert a new record
	public void create(StockData stockData) {
		try {
			 String SQL = "INSERT INTO stock (Symbol, Name, Price, BeginPrice, PE, PEG, PriceToBook, ROE, EPS, PRiceToSale, Volumn, Sector, OneYearTarget) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 jdbcTemplateObject.update( SQL, stockData.getSymbol(), stockData.getName(), stockData.getPrice(), stockData.getPrice(), stockData.getPe(),
					 stockData.getPeg(), stockData.getPriceToBook(), stockData.getRoe(), stockData.getEps(), stockData.getPriceToSale(),
					 stockData.getVolumn(), stockData.getSector(), stockData.getOneYearTarget());	
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
   
	public void update(StockData beginStockData, SpStockDataImporter dataImporter) {
		StockData newData = dataImporter.getPrevouseClose(beginStockData.getSymbol());
		
		newData.setPeChange((newData.getPe() - beginStockData.getPe())/beginStockData.getPe());
		newData.setPegChange((newData.getPeg() - beginStockData.getPeg())/beginStockData.getPeg());
		newData.setPbChange((newData.getPriceToBook() - beginStockData.getPriceToBook())/beginStockData.getPriceToBook());
		newData.setEpsChange((newData.getEps() - beginStockData.getEps())/beginStockData.getEps());
		newData.setPsChange((newData.getPriceToSale() - beginStockData.getPriceToSale())/beginStockData.getPriceToSale());
		newData.setPeChange((newData.getPe() - beginStockData.getPe())/beginStockData.getPe());
		newData.setDiffToTarget((newData.getPrice() - newData.getOneYearTarget())/(newData.getOneYearTarget()));
		
		String SQL = "UPDATE stock SET Price=?, Volumn=?, OneYearTarget=?, PriceChange=?, PEChange=?, PEGChange=?, PBChange=?, EPSChange=?, PSChange=?, DiffToTarget=?";
		 jdbcTemplateObject.update( SQL, newData.getPrice(), newData.getVolumn(), newData.getOneYearTarget(), newData.getPriceChange(),
				 newData.getPeChange(), newData.getPegChange(), newData.getPbChange(), newData.getEpsChange(), newData.getPsChange(),
				 newData.getDiffToTarget());
		 
	}
	
	// Reset all records, remove current data from DB, and read SP 500 list file and get their data and fill DB.
	// The data is the beginning of current year.
	@Override	
	public void reset() {
		// remove all data
		String deleteAllSQL = "delete from sp500.stock";
	    jdbcTemplateObject.update(deleteAllSQL);
	    String resetIDSQL = "ALTER TABLE sp500.stock AUTO_INCREMENT = 0";
	    jdbcTemplateObject.update(resetIDSQL);
	    
		// We use the data from the first day (actually the price of market close of previous year).new year day
		// market is closed.
		Calendar from = Calendar.getInstance();
		from.add(Calendar.YEAR, -1);
		from.set(Calendar.MONTH, Calendar.DECEMBER);
		from.set(Calendar.DAY_OF_MONTH, 29);
		Calendar to = Calendar.getInstance();
		to.set(Calendar.MONTH, Calendar.JANUARY);
		to.set(Calendar.DAY_OF_MONTH, 1);
		int count = 0; // for log info only
				
	    
	    try {	    	
	    	File file = new File("d:\\users\\henry\\My Code\\stock\\src\\com\\henry\\stock\\constituents.json");
			FileInputStream is = new FileInputStream(file);
//			InputStream is = getClass().getResourceAsStream("/constituents.json");  
		    ReadList readList = new ReadList();
		    
	    	SpStockData[] stockList = readList.readFile(is);	
	    	SpStockDataImporter importer = new SpStockDataImporter();
	    	
	    	for (SpStockData stock : stockList) {	    		
	    		StockData stockData = importer.getYearBegings(stock.getSymbol(), from, to);
	    		stockData.setSector(stock.getSector());
		    	create(stockData);
		    	++count;
		    }
	    	
	    	LOGGER.log(Level.INFO, "Total records is {0}", count);
	    
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
	
//	private void fillSector(SpStockData[] stockList, StockData stockData) {
//		for (SpStockData spStockData : stockList) {
//			if (stockData.getSymbol().equals(spStockData.getSymbol())) {
//				stockData.setSector(spStockData.getSector());
//			}
//		}
//	}
	public void updateAll() {
		try {
			 String SQL = "select * from sp500.stock";
			 List<StockData> stockDatas = jdbcTemplateObject.query( SQL, new StockDataMap());
			 
			 SpStockDataImporter dataImporter = new SpStockDataImporter();
			 for (StockData stockData: stockDatas) {
				 update(stockData, dataImporter);
			 }
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
		
}
