package com.henry.stock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({

	stockserviceTest.class,
	ReadListTest.class,
	SpStockDataImporterTest.class,
	StockJDBCTemplateTest.class,
	StockJDBCTemplateTest.class
})

public class JunitTestSuite {

}
