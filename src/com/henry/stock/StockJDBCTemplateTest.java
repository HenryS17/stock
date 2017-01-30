package com.henry.stock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StockJDBCTemplateTest {
	
	@Test
	public void test() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("StockJDBCTemplate");
			StockData testData = new StockData();
			
			testData.setSymbol("FB");
			testData.setName("Facebook, Inc.");
			testData.setEps(2.09);
			testData.setOneYearTarget(153.91);
			testData.setPeg(10.1);
			testData.setPe(63.18);
			testData.setPrice(105.05);
			testData.setPriceToBook(1.22);
			testData.setPriceToSale(123.11);
			testData.setRoe(23);
			testData.setSector("Technology");
			testData.setVolumn(18379500L);
			
			jdbcTemplate.create(testData);
		}
		catch (Exception e) {			
			fail();
		}
		
	}

}
