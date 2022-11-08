package com.bptn.exceptions;


@SuppressWarnings("all")
public class InvalidRequestException extends Exception {
  public InvalidRequestException() {
    super();
  }
  public InvalidRequestException(String msg) {
    super(msg);
  }
  public InvalidRequestException(String msg, Throwable cause) {   //this doesnt have to be here ( not a must)
    super(msg, cause);
  }
  public InvalidRequestException(Throwable cause) {  //this doesnt have to be here
    super(cause);
  }
}