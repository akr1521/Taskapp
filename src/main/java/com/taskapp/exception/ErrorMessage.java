package com.taskapp.exception;

public class ErrorMessage {
	private  int  httpStatusCode;
	private  String message;
	private String description ;
	public ErrorMessage( int  httpStatus ,String message ,  String description ) {
		this.httpStatusCode =  httpStatus; 
		this.message =  message; 
		this.description  = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
/*	
	static interface ErrorMessageConstants{
		 int NOT_FOUND = 404  ;
		  int INVALID_CATEGORY = 91 ;
		  
	}
	static interface ErrorMessageDescription {
	 String  errorMessage = " ";	
	
	}
	
*/}
