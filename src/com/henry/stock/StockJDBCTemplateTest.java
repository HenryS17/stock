package com.henry.stock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StockJDBCTemplateTest {
	
//	//@Test
//	public void testSetData() {
//		try {
//			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//		    StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
//			StockData testData = new StockData();
//			
//			testData.setSymbol("FB");
//			testData.setName("Facebook, Inc.");
//			testData.setEps(2.09);
//			testData.setOneYearTarget(153.91);
//			testData.setPeg(10.1);
//			testData.setPe(63.18);
//			testData.setPrice(105.05);
//			testData.setPriceToBook(1.22);
//			testData.setPriceToSale(123.11);
//			testData.setRoe(23.0d);
//			testData.setSector("Technology");
//			testData.setVolumn(18379500L);
//			
//			jdbcTemplate.create(testData);
//		}
//		catch (Exception e) {			
//			fail();
//		}
//		
//	}
	
//	@Test
//	public void testUpdateData() {
//		try {
//			 String SQL = "select * from sp500.stock where symbol='BF-B'";
//			 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//  		     StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
//			 
//			 SpStockDataImporter dataImporter = new SpStockDataImporter();
//			 StockData stockData = jdbcTemplate.getJDBCTempalte().queryForObject(SQL, new StockDataMap());
//			 jdbcTemplate.update(stockData, dataImporter);
//		}
//		catch (Exception e) {			
//			fail();
//		}
//	}
	
//	@Test
//	public void testUpdateAll() {
//		try {
//			 String SQL = "select * from sp500.stock where symbol='FB'";
//			 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//  		     StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
//			 
//			 jdbcTemplate.updateAll();
//		}
//		catch (Exception e) {			
//			fail();
//		}
//	}
	
	@Test
	public void testGetStock() {
		try {
			 String SQL = "select * from sp500.stock where symbol='FB'";
			 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
  		     StockJDBCTemplate jdbcTemplate =  (StockJDBCTemplate)context.getBean("stockJDBCTemplate");
			 
			 StockData stock = jdbcTemplate.getStock("FB");
			 
			 assertTrue(stock.getName() == "Facebook, Inc.");
		}
		catch (Exception e) {			
			fail();
		}
	}
}
