package com.prostack.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	ITestDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.insertRecords();
		
		List list  = dao.selectRecords();
		list.forEach(map->System.out.println(map));
		
		

	}

}
