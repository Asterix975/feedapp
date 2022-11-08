package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidHistoryException extends Exception {

	public InvalidHistoryException() {
		super();
	}
	public InvalidHistoryException(String message) {
		super(message);
	}
	
	
	public InvalidHistoryException(String message, Throwable cause, boolean enableSuppression,  // not necessary 
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidHistoryException(String message, Throwable cause) { //not necessary 
		super(message, cause);
	}

	public InvalidHistoryException(Throwable cause) {    //not necessary  
		super(cause);
	}
	
}
