package com.taskapp.exception;

public class TaskNotFoundException  extends BaseException{

	public  TaskNotFoundException (String message) {
			super ( message);
	}
	
	public  TaskNotFoundException (  int   httpStatus ,String message) {
		   super (  message);
}

}
