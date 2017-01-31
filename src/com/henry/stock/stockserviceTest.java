package com.henry.stock;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;

public class stockserviceTest {
	@Test
	public void test() {
		try {
			stockservice service = new stockservice();
			
			service.reset();	
		}
		catch (Exception e) {
			fail();
		}
	}

}
