package com.taskapp.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
	
	@Id
private String id ;
private LocalDateTime dateOfCreation;
private LocalDateTime deadline;
private  String name; 
private  String description;
private  List<Subtask> subtasks;
private  String category;



public Task() {
	
}

public Task(LocalDateTime dateOfCreation, LocalDateTime deadline, String name, String description, List<Subtask> subtasks,
		String category) {
	super();
	this.dateOfCreation = dateOfCreation;
	this.deadline = deadline;
	this.name = name;
	this.description = description;
	this.subtasks = subtasks;
	this.category = category;
}
public LocalDateTime getDateOfCreation() {
	return dateOfCreation;
}
public void setDateOfCreation(LocalDateTime dateOfCreation) {
	this.dateOfCreation = dateOfCreation;
}
public LocalDateTime getDeadline() {
	return deadline;
}
public void setDeadline(LocalDateTime deadline) {
	this.deadline = deadline;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public List<Subtask> getSubtasks() {
	return subtasks;
}
public void setSubtasks(List<Subtask> subtasks) {
	this.subtasks = subtasks;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}



}
