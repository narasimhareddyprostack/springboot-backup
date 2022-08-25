package com.prostack.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ITestDaoImpl implements ITestDao {
    
	
	@Autowired
    JdbcTemplate jt;
	
	@Override
	public void insertRecords() {
		// TODO Auto-generated method stub
		jt.update("insert into emp values(101,'Rahul Gandhi',45000')");
	}

	@Override
	public List selectRecords() {
		return jt.queryForList("select * from emp");
		
	}

}
