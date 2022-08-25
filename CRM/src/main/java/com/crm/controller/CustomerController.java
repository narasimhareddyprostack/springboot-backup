package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.crm.dao.RegistrationDaoImpl;
import com.crm.model.CustomerBean;

@Controller	
public class CustomerController {
	
	@Autowired	
	RegistrationDaoImpl regDao;
	
	@GetMapping("/index")
	public String getIndexPage() {
		System.out.println("Test Case 123 ");
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegistrationPage(@ModelAttribute("custBean") CustomerBean customerBean) {
		
		boolean flag = regDao.saveCustomer(customerBean);
		System.out.print(flag);
		return "signup";
	}
	
	@GetMapping("/save")
	public String RegisterCustomer() {
		
		return "success";
	}
	
		
}