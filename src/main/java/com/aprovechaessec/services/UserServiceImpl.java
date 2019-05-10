package com.aprovechaessec.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aprovechaessec.entity.Role;
import com.aprovechaessec.entity.Users;
import com.aprovechaessec.repositories.UserRepository;
import com.aprovechaessec.repositories.UserRepositoryImpl;

@Service
public class UserServiceImpl implements  UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepositoryImpl userRepositoryImpl;
    List<SimpleGrantedAuthority> authorities =null;
	public void creatUser(Users user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
//		Role role = new Role("ROLE_USER");
		Role role = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public void creatAdmin(Users user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setSerial("");
//		Role role = new Role("ROLE_ADMIN");
		Role role = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public Users findOne(String email) {
		//return userRepository.findByEmail(email).orElse(null);
		Users user = userRepositoryImpl.getUserbyEmail(email);
		return user;
	}
	
	public boolean isUserPresent(String email) {
		Users user = userRepository.findByEmail(email).orElse(new Users());
		if(user!= null && user.getEmail() != null)
			return true;
		return false;
	}
	
	public List<Users> getFindAll() {
		
		return userRepository.findAll();
	}
	
	public Users findByName(String name){
//		List<Users> users = userRepository.findByNameStartingWith(name);
		Users users = null;
		try {
			users = userRepositoryImpl.getUserbyName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails userDetails=null;
		 
		try {
		    Users user = userRepositoryImpl.getUserbyEmail(email);
		    if(user == null) {
		      throw new UsernameNotFoundException("User not found");
		    }
		   user.getRoles().forEach(role ->{
			   if(role.getName().indexOf("USER")!=-1) {
				   authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			   }
			   if(role.getName().indexOf("ADMIN")!=-1) {
				   authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			   }
		   }); 
		// @formatter:on

//		     authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		   if(authorities != null)
		    userDetails= new User(user.getName(), user.getPassword(), authorities);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	    return userDetails;
	  }
}
