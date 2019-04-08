package com.aprovechaessec.services;

import java.util.List;

import com.aprovechaessec.entity.Users;

public interface UserService {
	
	public void creatUser(Users user);
	public void creatAdmin(Users user);
	public Users findOne(String email);
	public boolean isUserPresent(String email);
	public List<Users> getFindAll();
	public List<Users> findByName(String name);
}
