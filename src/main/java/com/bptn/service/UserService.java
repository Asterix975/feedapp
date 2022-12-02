package com.bptn.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.UserID;
import com.bptn.repository.UserRepository;

@Service
public class UserService {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 
	
	
@Autowired 
UserRepository userRepository; 

	public void validateUserId (String username) throws InvalidUserNameException {
		Optional<UserID> opt = this.userRepository.findById(username);
		
		if (opt.isEmpty()) {
			logger.error("User does not exist", username);
			throw new InvalidUserNameException( "User does not exist. Try Again"); 
		} else {
			logger.error("Username Validated");
		}
	}
	
	/*String message;
	Optional<UserID> userID = this.userRepository.findById(username);
	if (userID!=null) { 
		message = "User exists"; 
	} else {
		throw new InvalidUserNameException("Invalid name, user doesnt exist");	
	}
	return message; */
}
