package com.bptn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.models.userID;
import com.bptn.repository.LogInRepository;

@Service
public class LoginService {
	
	
	
	@Autowired    //dependecy injection : enables automatic dependency injection
	LogInRepository loginRepository; 
	
	
	public String validateUserCredentials(userID userParam) {
		
		String message = null; 
		
		//userID userID = this.loginRepository.findById(userParam.getUsername()).orElse(null); 
		
		Optional<userID>opt = this.loginRepository.findById(userParam.getUsername());
		
		
		if ( opt.isPresent()){
		//if (userID != null) {
			//if (userID.getUserPassword().equals(userParam.getUserPassword())) {
			if (opt.get().getUserPassword().equals(userParam.getUserPassword())) {
			
				message = "Login Succesful"; //password is right 
				
			} else {
				message = "Pasword Incorrect"; 
			}
			
		 }else {
				message = "User doesnt exists"; 
			}
		
		return message; 
		}
		
}
