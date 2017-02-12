package com.henry.stock;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;

public class stockserviceTest {
//	@Test
//	public void testReset() {
//		try {
//			stockservice service = new stockservice();
//			
//			service.reset();	
//		}
//		catch (Exception e) {
//			fail();
//		}
//	}

	@Test
	public void testTopTen() {
		try {
			stockservice service = new stockservice();
			
			String json = service.getTopTen();
			System.out.print(json);
		}
		catch (Exception e) {
			fail();
		}
	}
}
