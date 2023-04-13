package com.taskapp;

import java.sql.Date;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskapp.model.Subtask;
import com.taskapp.model.Task;
import java.util.*;
import com.taskapp.repository.TaskRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication
public class TaskAppApplication {

	@Autowired
	TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskAppApplication.class, args);
	}
	

//	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		 Subtask subtask = new Subtask( "Bgc", "Background Check");
//		  List<Subtask> subtaskList = new ArrayList<>(); subtaskList.add(subtask);
////		  ZoneId zoneId = ZoneId.of("UTC+1");
////		  ZonedDateTime deadline = ZonedDateTime.of(2015, 11, 30, 23, 45, 59, 1234, zoneId);
//		  LocalDateTime deadline =  LocalDateTime.now().plusDays(144);
//		  
//		 System.out.println(  " Command  Liner is running ");
//		 Task   task =  new Task(  LocalDateTime.now(),deadline ,"Onboarding" ,"Onboarding employee", subtaskList, "employee");
//		 Task savedTask =   taskRepository.insert( task);
//		 System.out.println(  " Task status :    "  +  savedTask.getCategory() );
//	}
	 @RequestMapping("/error")
	    public String handleError(HttpServletRequest request) {
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	        
	        if (status != null) {
	            Integer statusCode = Integer.valueOf(status.toString());
	        
	            if(statusCode == HttpStatus.NOT_FOUND.value()) {
	                return "error-404";
	            }
	            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	                return "error-500";
	            }
	        }
	        return "error";
	    }
	
}
