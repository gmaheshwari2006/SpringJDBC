package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCorporateEventDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getEmployeeRows() {
		return jdbcTemplate.queryForObject("select count(*) from employee",
				Integer.class);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void queryExecution(String name) {
		int rowCount = this.jdbcTemplate.queryForObject(
				"select count(*) from employee", Integer.class);
		System.out.println("rowcount: " + rowCount);
		name = "Purohit";
		int countOfActorsNamedJoe = this.jdbcTemplate.queryForObject(
				"select count(*) from employee where name = ?", Integer.class,
				name);
		System.out.println("countOfActorsNamedJoe: " + countOfActorsNamedJoe);

		EmployeeEntity emp = this.jdbcTemplate.queryForObject(
				"select id, name from employee where id = ? and name = ?",
				new Object[] { 4, name }, 
				new RowMapper<EmployeeEntity>() {
					@Override
					public EmployeeEntity mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						EmployeeEntity employee = new EmployeeEntity();
						employee.setId(rs.getInt("id"));
						employee.setName(rs.getString("name"));
						return employee;
					}
				}
				);
		System.out.println("actor: " + emp.getName());

	}
		public List<EmployeeEntity> fetchAllEmployees() {
			
		List<EmployeeEntity> emp = this.jdbcTemplate.query(
				"select id, name from employee",
				new RowMapper<EmployeeEntity>() {
					public EmployeeEntity mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						EmployeeEntity employee = new EmployeeEntity();
						employee.setId(rs.getInt("id"));
						employee.setName(rs.getString("name"));
						return employee;
					}
				});
		return emp;
	}

	public void testInterface(){
		new MyInterface() {
			
			@Override
			public void myname(String name) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
