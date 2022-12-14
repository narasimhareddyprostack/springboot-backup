package com.crm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crm.model.CustomerBean;

@Repository	
public class RegistrationDaoImpl implements IRegistrationDao {

	@Autowired
	JdbcTemplate jt;
	
	public boolean saveCustomer(CustomerBean cusomterBean) {
		// TODO Auto-generated method stub
		
		String command_SQL = "insert into User values(?,?,?,?)";
	
		//jt.update(command_SQL, cusomterBean.getFirstName());
		
		jt.update(command_SQL,cusomterBean.getFirstName(),cusomterBean.getEmail(),cusomterBean.getPassword(),cusomterBean.getMobile());
		//jt.update(command, );
		return true;
	}

}
