package com.taskapp.utils;

import com.taskapp.model.Task;

public class TaskUtils {

/*
 * An ObjectMapper to retrieve the derived object	
 */
	public static Task mapToObject(Task task) {
		Task mappedTask = new Task();
		mappedTask.setCategory(task.getCategory());
		mappedTask.setDateOfCreation(task.getDateOfCreation());
		mappedTask.setDeadline(task.getDeadline());
		mappedTask.setDescription(  task.getDescription());
		mappedTask.setId( task.getId());
		mappedTask.setName( task.getName());
		mappedTask.setSubtasks(task.getSubtasks());
		return mappedTask;
	}
	
}
