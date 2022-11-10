package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class InvalidUserCredentialsException extends Exception{

	String errorMessage;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public InvalidUserCredentialsException() {
		super();
		logger.debug("Invalid Name. Please try again.");
		
	}
	
	public InvalidUserCredentialsException(String errorMessage) { 
	    super(errorMessage);  
	    logger.debug("Invalid Name. Please try again.");
	
	
	}
	}   