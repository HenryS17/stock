package com.henry.stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam; 

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.json.*;

@Path("/stockservice")
public class stockservice {
	private static final Logger LOGGER = Logger.getLogger(stockservice.class.getName());

	@GET
	@Path("/topten")
	@Produces(MediaType.APPLICATION_JSON)	
	public String getTopTen() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
	    
	    List<StockData> list = jdbcTemplate.getTopTen();
		
		JsonArrayBuilder arraryBuilder = Json.createArrayBuilder();
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		
		for (StockData stock : list) {
			jsonBuilder.add("name", stock.getName());
			jsonBuilder.add("symbol", stock.getSymbol());
			jsonBuilder.add("return%", stock.getPriceChange()*100);
			jsonBuilder.add("sector", stock.getSector());
			arraryBuilder.add(jsonBuilder);
		}
				 
		return arraryBuilder.build().toString();
	}
	
	@GET
	@Path("/bottomten")
	@Produces(MediaType.APPLICATION_JSON)	
	public String getBottomTen() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
	    
	    List<StockData> list = jdbcTemplate.getBottomTen();
		
		JsonArrayBuilder arraryBuilder = Json.createArrayBuilder();
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		
		for (StockData stock : list) {
			jsonBuilder.add("name", stock.getName());
			jsonBuilder.add("symbol", stock.getSymbol());
			jsonBuilder.add("ytd return%", stock.getPriceChange());
			jsonBuilder.add("sector", stock.getSector());
			arraryBuilder.add(jsonBuilder);
		}
				 
		return arraryBuilder.build().toString();
	}
	
	@GET
	@Path("/stock/{symbol}")
	@Produces(MediaType.APPLICATION_JSON)	
	public String getStock(@PathParam("symbol") String symbol) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
	    
	    StockData stock = jdbcTemplate.getStock(symbol);

		SpStockDataImporter dataImporter = new SpStockDataImporter();
		BigDecimal curPrice = dataImporter.getCurrentPrice(symbol);
		
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();		
		
		jsonBuilder.add("name", stock.getName());
		jsonBuilder.add("symbol", stock.getSymbol());
		jsonBuilder.add("price", curPrice);
		jsonBuilder.add("previous close", stock.getPrice());
		jsonBuilder.add("previous close ytd return%", stock.getPriceChange()*100);
//		jsonBuilder.add("ytd return%", (curPrice - stock.getBeginPrice())/stock.getBeginPrice()*100);
//		jsonBuilder.add("previous close return%", stock.getPriceChange()*100);
//		jsonBuilder.add("previous close return%", stock.getPriceChange()*100);
//		jsonBuilder.add("previous close return%", stock.getPriceChange()*100);
//		jsonBuilder.add("sector", stock.getSector());
				 
		return jsonBuilder.build().toString();
	}
	
	// My secret post action to reset all data at the beginning of the year.
	@POST
	@Path("/initalldata")
	public void reset() {
		LOGGER.log(Level.INFO, "Do reset");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
	    jdbcTemplate.reset();  
	}
}
