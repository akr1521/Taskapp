package com.taskapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.taskapp.exception.ErrorMessageConstants;
import com.taskapp.exception.ErrorMessageDescription;
import com.taskapp.exception.InvalidRequestException;
import com.taskapp.model.Subtask;
import com.taskapp.model.Task;
import com.taskapp.repository.TaskRepository;
import com.taskapp.utils.TaskUtils;

@Service
public class TaskService {

    // In-memory list to store tasks
    private final List<Task> tasks = new ArrayList<>();

    @Autowired
	TaskRepository taskRepository;
    
    @Autowired
    MongoTemplate mongoTemplate;
    // Generate a new id for each new task
    private long nextId = 1;

    // Retrieve all tasks
    public List<Task> getAllTasks() {
    	System.out.println(    "  In am inside  the service class");
        return taskRepository.findAll();
    }

    // Retrieve a single task by id
    public Task getTaskById(String id) {
    			return	taskRepository.findById(id).orElse(null);
    				
    }
    
    public List<Task>  getTaskByCategory( String category  )  {
    	    Query query = new Query  () ;
    	 	query.addCriteria(Criteria.where("category").is(category));
    	 return	mongoTemplate.find(  query, Task.class);
    }
    
    public List<Task>  getTaskBySubCategory( String subCategory  )  {
	    Query query = new Query  () ;
//      List<List<Subtask>>  subtasks =getAllTasks().parallelStream().map( subtask -> subtask.getSubtasks()).collect(Collectors.toList()) ;
	    // mongoTemplate.find(  query, List.class);
	    query.addCriteria(Criteria.where("subtasks.name").is(subCategory));   
	   return  mongoTemplate.find(  query,Task.class );
}

    

    // Create a new task
    public void createTask(Task task) {
    	 	taskRepository.save(task);
    }

    // Update an existing task by id
    public Task updateTask( Task updatedTask) {
           
    	if ( Objects.isNull(getTaskById(updatedTask.getId()))) {
    				throw new InvalidRequestException (  ErrorMessageConstants.INVALID_REQUEST,ErrorMessageDescription.INVALID_ID);
    	}
       return   taskRepository.save(TaskUtils.mapToObject(updatedTask));
    }

    // Delete an existing task by id
    public void deleteTask(String id) {
    	Optional<Task> task = taskRepository.findById(id);
    	
    	taskRepository.deleteById( id);
    	
   }
    
    // Delete an existing Subtask by id
    public void deleteSubTask(String name) {
    	
   }
    
}
