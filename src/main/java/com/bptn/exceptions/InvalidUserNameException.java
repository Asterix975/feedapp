package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class InvalidUserNameException extends Exception{

	String errorMessage;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public InvalidUserNameException() {
		super();
		logger.debug("Invalid Name. Please try again.");
		
	}
	
	public InvalidUserNameException(String errorMessage) { 
	    super(errorMessage);  
	    logger.debug("Invalid Name. Please try again.");
	
	
	}
	}   