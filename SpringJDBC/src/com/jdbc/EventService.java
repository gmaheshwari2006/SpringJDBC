package com.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EventService {

	@Autowired
	private JdbcCorporateEventDao jdbcCorporateEventDao;

	/*public JdbcTemplate testJdbcTemplate() {
		return jdbcCorporateEventDao.getJdbcTemplate();
	}*/

	public int getEmployeeRows() {
		return jdbcCorporateEventDao.getEmployeeRows();
	}

	public void queryExecution() {
		jdbcCorporateEventDao.queryExecution("rohit");
		
	}

	public List<EmployeeEntity> fetchAllEmployees() throws Exception {
		/*if(true)
		throw new Exception();*/
		return jdbcCorporateEventDao.fetchAllEmployees();
	}
}
