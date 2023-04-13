package com.taskapp.exception;

public class BaseException  extends RuntimeException {
	 private int httpStatusCode;
	 private String message;
	 
	 public BaseException(String message) {
		 super (  message);
	 }
	 
	 public  BaseException (  int httpStatusCode,String message ) {	 
		 	this.httpStatusCode  = httpStatusCode;
		 	this.message = message;
	 }

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	 
	 
}
