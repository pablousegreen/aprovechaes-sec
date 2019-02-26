package com.aprovechaessec.services;

import java.util.List;

import com.aprovechaessec.entity.User;

public interface UserService {
	
	public void creatUser(User user);
	public void creatAdmin(User user);
	public User findOne(String email);
	public boolean isUserPresent(String email);
	public List<User> getFindAll();
	public List<User> findByName(String name);
}
