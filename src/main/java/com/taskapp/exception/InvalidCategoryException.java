package com.taskapp.exception;

public class InvalidCategoryException  extends BaseException{
	private String message;
	private int httpStatusCode;
	
	public  InvalidCategoryException (String message) {
			 super( message);
	}
	public  InvalidCategoryException (  int httpStatusCode,  String message) {
		 super( httpStatusCode,message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	
}	
