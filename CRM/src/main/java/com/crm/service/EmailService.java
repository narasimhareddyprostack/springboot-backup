package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	JavaMailSender mailSend;
	public void sendEmailtoUser(String email, String name) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject("User Registration....");
			mailMessage.setText("Hello,Good Evening");
			mailSend.send(mailMessage);
	}	
}
