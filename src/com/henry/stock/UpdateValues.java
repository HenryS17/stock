package com.henry.stock;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateValues  implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(UpdateValues.class.getName());
	public UpdateValues() {		
	}
	@Override
    public void run() {
		try {
			String time = LocalDate.now().toString();
			LOGGER.log(Level.INFO, time);
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("StockJDBCTemplate");
		    jdbcTempalte.updateAll(); 
		}
		catch(Exception e) {
		
		}
    }
}
