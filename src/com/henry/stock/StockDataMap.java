package com.henry.stock;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StockDataMap implements RowMapper<StockData> {

	@Override
	public StockData mapRow(ResultSet rs, int rowNum) throws SQLException {
		StockData stockData = new StockData();
		
		stockData.setName(rs.getString("Name"));		
		stockData.setSymbol(rs.getString("Symbol"));
		stockData.setPrice(rs.getDouble("Price"));
		stockData.setPe(rs.getDouble("PE"));
		stockData.setPeg(rs.getDouble("PEG"));
		stockData.setPriceToBook(rs.getDouble("PriceToBook"));
		stockData.setRoe(rs.getDouble("ROE"));
		stockData.setEps(rs.getDouble("EPS"));
		stockData.setPriceToSale(rs.getDouble("PriceToSale"));
		stockData.setBeginPrice(rs.getDouble("BeginPrice"));
		stockData.setOneYearTarget(rs.getDouble("OneYearTarget"));
		stockData.setPriceChange(rs.getDouble("PriceChange"));
		stockData.setDiffToTarget(rs.getDouble("DiffToTarget"));
		stockData.setSector(rs.getString("Sector"));
		
		return stockData;
	}

}
