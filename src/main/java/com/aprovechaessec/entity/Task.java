package com.aprovechaessec.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Task")
public class Task {
	
	@Id
	private String id;
	private String time;
	private String startTime;
	private String stopTime;
	private String description;
	private User user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task(String time, String startTime, String stopTime, String description, User user) {
		this.time = time;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
		this.user = user;
	}
	public Task(String time, String startTime, String stopTime, String description) {
		
		this.time = time;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
	}
	
	public Task() {
		
	}
	
}
