package com.henry.stock;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateValues  implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(UpdateValues.class.getName());
	public UpdateValues() {		
	}
	@Override
    public void run() {
		try {
			String time = LocalDate.now().toString();
			LOGGER.log(Level.INFO, "UpdateValues at: {0}", time);
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
		    jdbcTemplate.updateAll(); 
		}
		catch (BeansException e) {
			LOGGER.log(Level.SEVERE, "BeansException when UpdateValues");
			LOGGER.log(Level.INFO, e.toString());
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception when UpdateValues");
			LOGGER.log(Level.INFO, e.toString());
		}
    }
}
