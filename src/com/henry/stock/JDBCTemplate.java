package com.henry.stock;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplate implements DataDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void reset() {
	}
	
		
}
