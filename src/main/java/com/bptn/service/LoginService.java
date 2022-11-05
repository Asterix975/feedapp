package com.bptn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.models.Post;
import com.bptn.models.UserID;
import com.bptn.repository.LogInRepository;

@Service
public class LoginService {
	
	
	
	@Autowired    //dependecy injection : enables automatic dependency injection
	LogInRepository loginRepository; 
	
	public String validateUserCredentials(UserID userParam) {
		
		String message = null; 
		
		Optional<UserID>opt = this.loginRepository.findById(userParam.getUsername());
		
		if ( opt.isPresent()){
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
	
	public List <Post>getPostsByUsername(String username){
		Optional <UserID> opt = this.loginRepository.findById(username);
		return opt.orElse(null).getPosts();
	}
	
		
}
