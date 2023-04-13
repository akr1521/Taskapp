package com.taskapp.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.taskapp.exception.*;
import com.taskapp.exception.InvalidCategoryException;
import com.taskapp.model.Task;
import com.taskapp.service.TaskService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskappController {

	  // Task service will be injected in this field
    private final TaskService taskService;

    // Constructor injection
    public TaskappController(TaskService taskService) {
    	System.out.println( "  Conntroller  cosntructor is calledd");
        this.taskService = taskService;
    }
	
    
   @RequestMapping(value ="/all", method   = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks() {
    	
    	List<Task> allTasks = taskService.getAllTasks();
    	return new ResponseEntity<>( allTasks, HttpStatus.OK);
    }
   
   
    @RequestMapping(value ="/category/{category}", method= RequestMethod.GET)
    public ResponseEntity<List<Task>> fetchTaskByCategory(@PathVariable("category" ) String category) {
   	
    	List<Task> allTasks = taskService.getTaskByCategory(category);
    	if ( Objects.nonNull(allTasks)) {
    	 	return new ResponseEntity<>( allTasks, HttpStatus.OK); 			
    	}
    	throw new InvalidCategoryException( ErrorMessageConstants.INVALID_CATEGORY , ErrorMessageDescription.INVALID_CATEGORY );
    }
    
    
    
    @RequestMapping(value ="/subcategory/{subcategory}", method= RequestMethod.GET)
    public ResponseEntity<List<Task>> fetchTaskBySubCategory(@PathVariable("subcategory" ) String subcategory) {
   	
    	List<Task> allTasks = taskService.getTaskBySubCategory(subcategory);
    	if ( Objects.nonNull(allTasks)) {
    	 	return new ResponseEntity<>( allTasks, HttpStatus.OK); 			
    	}
    	throw new InvalidCategoryException( ErrorMessageConstants.INVALID_SUBCATEGORY , ErrorMessageDescription.INVALID_SUBCATEGORY );
    }
    

    @RequestMapping(value="/create" , method= RequestMethod.POST) 
    public ResponseEntity<String> createTask(@RequestBody Task task) {
    		 if ( Objects.isNull(task)) 
    		 {
    			 throw new  InvalidRequestException  ( ErrorMessageConstants.INVALID_REQUEST, ErrorMessageDescription.INVALID_CATEGORY);
  
    		 }
    		 taskService.createTask(task);

        return new ResponseEntity<>( MessageConstants.DONE ,  HttpStatus.OK ) ;
    }

    @RequestMapping(value="/delete/{id}" , method= RequestMethod.DELETE) 
    public ResponseEntity<String> deleteTask( @PathVariable ( "id" )String id) {
    		 if (   Objects.isNull( id ))
    		 {
    			  throw new InvalidRequestException( ErrorMessageConstants.INVALID_REQUEST, ErrorMessageDescription.INVALID_ID);
    		 }
    		 	taskService.deleteTask(id);
    	return new ResponseEntity< > ( MessageConstants.DONE ,  HttpStatus.OK);
    }
	
    @RequestMapping(value="/delete/subtask/{name}" , method= RequestMethod.DELETE) 
    public ResponseEntity<String> deleteSubTask( @PathVariable ( "name" )String name) {
    		 if (   Objects.isNull( name ))
    		 {
    			  throw new InvalidRequestException( ErrorMessageConstants.INVALID_REQUEST, ErrorMessageDescription.INVALID_ID);
    		 }
    		 	taskService.deleteSubTask(name);
    	return new ResponseEntity< > ( MessageConstants.DONE ,  HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/modify" , method= RequestMethod.PUT) 
    public ResponseEntity<String> deleteTask( @RequestBody Task task) {
    		 if (   Objects.isNull( task ))
    		 {
    			  throw new InvalidRequestException( ErrorMessageConstants.INVALID_REQUEST, ErrorMessageDescription.INVALID_ID);
    		 }
    		 	taskService.updateTask( task);
    	return new ResponseEntity< > ( MessageConstants.DONE ,  HttpStatus.OK);
    }
	
    
}
