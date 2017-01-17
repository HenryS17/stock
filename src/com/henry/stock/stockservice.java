package com.henry.stock;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/stockservice")
public class stockservice {
	private static final Logger LOGGER = Logger.getLogger(stockservice.class.getName());

	@GET
	@Path("/topten")
	@Produces(MediaType.APPLICATION_JSON)	
	public StockData getTopTen() {
		//public StockData getTopTen() {
		StockData stock = new StockData();
		
	//	try {
//		LocalDate date = LocalDate.now();
//		
//		stock.setDate(date);
		stock.setName("Facebook");
//		stock.setPe(1.2f);
//		stock.setPrice(100.1f);
		stock.setSymbol("FB");
	//	}
//		catch (Exception e){
//			DebugExceptionMapper de = new DebugExceptionMapper();
//			
//			de.toResponse(e);
//		}
	
	//	System.out.println(stock.toString());
		LOGGER.log(Level.INFO, stock.toString());
		return stock;
	}
	
	// My secret post action to reset all data at the beginning of the year.
	@POST
	@Path("/initalldata")
	public void Reset() {
		LOGGER.log(Level.INFO, "Do reset");
	}
}
