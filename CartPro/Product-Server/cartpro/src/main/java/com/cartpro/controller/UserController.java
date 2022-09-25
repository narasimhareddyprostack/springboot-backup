package com.cartpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartpro.model.User;
import com.cartpro.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	/*
	 * API: localhost:8080/api/user/registration
	 * Method Type:POST
	 * Required Fields: name,username,password
	 */
	@PostMapping("/api/user/registration")
	public ResponseEntity<?> register(@RequestBody  User user){
		System.out.println("Test Case 123");
		System.out.println(user.getName());
		//we need to check, user already exists or not
		
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
		
	}
	 
	/* Login
	 * API: localhost:8080/api/user/login
	 * Method Type:POST
	 * Required Fields: username,password
	 */
}
