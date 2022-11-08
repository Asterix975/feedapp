package com.bptn.exceptions;

@SuppressWarnings("all")
public class InvalidImageMetaDataException extends Exception {

	public InvalidImageMetaDataException() {
		super();
	}
	
	public InvalidImageMetaDataException(String message) {   
		super(message);
	}

	public InvalidImageMetaDataException(String message, Throwable cause, boolean enableSuppression, //not necessary 
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidImageMetaDataException(String message, Throwable cause) {  //not necessary 
		super(message, cause);
	}

	public InvalidImageMetaDataException(Throwable cause) { //not necessary 
		super(cause);
	}
	

}
