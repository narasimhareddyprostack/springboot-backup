package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crm.dao.RegistrationDaoImpl;
import com.crm.model.CustomerBean;
import com.crm.service.EmailService;

@Controller	
public class CustomerController {
	
	@Autowired	
	RegistrationDaoImpl regDao;
	
	@Autowired
	EmailService emailServer;
	
	@GetMapping("/index")
	public String getIndexPage() {
		System.out.println("Test Case 123 ");
		return "index";
	}
	
	@GetMapping("/signup")
	public String getRegistrationPage(Model model) {
		CustomerBean customerBean = new CustomerBean();
		model.addAttribute("custBean", customerBean);
		return "signup";
	}
	
	@PostMapping("/save")
	public String RegisterCustomer(@ModelAttribute("custBean") CustomerBean customerBean) {
		System.out.println(customerBean.getFirstName());
		boolean flag = regDao.saveCustomer(customerBean);
		System.out.print(flag);
		
		if(flag == true) {
			//send email to user
			emailServer.sendEmailtoUser(customerBean.getEmail(),customerBean.getFirstName());
		}
		return "success";
	}
	
		
}
