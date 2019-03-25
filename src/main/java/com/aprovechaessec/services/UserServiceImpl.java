package com.aprovechaessec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aprovechaessec.entity.Role;
import com.aprovechaessec.entity.User;
import com.aprovechaessec.repositories.UserRepositoryImpl;
import com.aprovechaessec.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepositoryImpl userRepositoryImpl;
	
	public void creatUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role role = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public void creatAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role role = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public User findOne(String email) {
		//return userRepository.findByEmail(email).orElse(null);
		User user = userRepositoryImpl.getUserbyEmail(email);
		return user;
	}
	
	public boolean isUserPresent(String email) {
		User user = userRepository.findByEmail(email).orElse(new User());
		if(user!= null && user.getEmail() != null)
			return true;
		return false;
	}
	
	public List<User> getFindAll() {
		
		return userRepository.findAll();
	}
	
	public List<User> findByName(String name){
		List<User> users = userRepository.findByNameStartingWith(name);
		return users;
	}
}
