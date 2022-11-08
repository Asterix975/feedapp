package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidQueryException extends Exception {

	public InvalidQueryException() {
		super();
	}
	public InvalidQueryException(String message) {
		super(message);
	}

	public InvalidQueryException(String message, Throwable cause, boolean enableSuppression, // Not needed
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidQueryException(String message, Throwable cause) { // Not needed
		super(message, cause);
	}

	public InvalidQueryException(Throwable cause) {  // Not needed
		super(cause); 
	}

	
}
