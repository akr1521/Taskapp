package com.taskapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


	  @ExceptionHandler(value = {InvalidCategoryException.class})
	  public ResponseEntity<ErrorMessage> resourceNotFoundException(InvalidCategoryException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        ex.getHttpStatusCode(),
	        ex.getLocalizedMessage(),
	        ex.getMessage());
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }   
	
	  @ExceptionHandler(value = {InvalidRequestException.class})
	  public ResponseEntity<ErrorMessage> invalidRequestException(InvalidRequestException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        ex.getHttpStatusCode(),
	        ex.getLocalizedMessage(),
	        ex.getMessage());
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }   
	
	  @ExceptionHandler(value = {TaskNotFoundException.class})
	  public ResponseEntity<ErrorMessage> invalidRequestException(TaskNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        ex.getHttpStatusCode(),
	        ex.getLocalizedMessage(),
	        ex.getMessage());
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  } 
	  
	  
}
