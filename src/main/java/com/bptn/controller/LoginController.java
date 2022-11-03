package com.bptn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.models.userID;
import com.bptn.service.LoginService;

@RestController
public class LoginController {
	
	//private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass()); //different from carlos code
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	LoginService loginService; 
	
	@PostMapping ("login")
	public String validateUserCredentials(@RequestBody userID userID) {
		
		
		logger.debug("Validating Credentials: {}", userID );
		String response = this.loginService.validateUserCredentials(userID);
		
		
		return response; 
	}

}
