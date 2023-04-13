package com.taskapp.exception;

public class InvalidRequestException  extends BaseException{

	public InvalidRequestException(int httpStatusCode, String message) {
		super(httpStatusCode, message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
