package com.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCServiceClient {

	private ApplicationContext context;

	private EventService service;

	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		JDBCServiceClient serviceClient = new JDBCServiceClient();
		serviceClient.processClient();
	}

	private void processClient() {
	//	context = new FileSystemXmlApplicationContext(new String[] { "src/com/jdbc/services.xml" });
		context=new ClassPathXmlApplicationContext("com/jdbc/services.xml");
		service = (EventService) context.getBean("service");
		//System.out.println("service" + service.testJdbcTemplate());
		int count = service.getEmployeeRows();
		System.out.println("count: " + count);
		service.queryExecution();
		List<EmployeeEntity> list;
		try {
			list = service.fetchAllEmployees();
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
