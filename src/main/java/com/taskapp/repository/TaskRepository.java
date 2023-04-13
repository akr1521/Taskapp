package com.taskapp.repository;

import org.springframework.stereotype.Repository;

import com.taskapp.model.Task;

import org.springframework.data.mongodb.repository.MongoRepository;
@Repository	
public interface  TaskRepository  extends MongoRepository<Task, String>{

	

}
