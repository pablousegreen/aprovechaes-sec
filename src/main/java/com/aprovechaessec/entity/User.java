package com.aprovechaessec.entity;

import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	
	@Id
    private String id;
	
	@NotEmpty
//	@Email
//	@Column(unique=true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min=4)
	private String password;
	private List<Task> tasks;
	private List<Role> roles;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User(String email, String name, String password) {
		
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public User(String email, String name, @Size(min = 4) String password, List<Task> tasks, List<Role> roles) {
//		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.tasks = tasks;
		this.roles = roles;
	}

	
	public User() {
		
	}
	
}
