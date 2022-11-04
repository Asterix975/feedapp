package com.bptn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidPostException extends Exception{

	String errorMessage;

	private static final long serialVersionUID = 4711357458911324597L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public InvalidPostException() {
		super();
		logger.debug("Invalid Post type. Please try again.");
		
	}
	
	public InvalidPostException(String errorMessage) { 
	    super(errorMessage);  
	    logger.debug("Invalid Post type. Please try again.");
	
	
	}
	}   