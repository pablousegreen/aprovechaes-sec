package com.aprovechaessec.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Role")
public class Role {
	
	@NotEmpty
	private String name;
	private List<User> users;
	
	public Role(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}
	public Role(String name) {
		this.name = name;
	}
	
	public Role() {
		
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
