package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidUserNameException extends Exception{

	String errorMessage;

	private static final long serialVersionUID = 4711357458911324597L;
	
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