package com.aprovechaessec.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aprovechaessec.entity.Users;
import com.aprovechaessec.services.TaskService;
import com.aprovechaessec.services.UserServiceImpl;

@Controller
public class ProfileController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired 
	private UserServiceImpl userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		String name = principal.getName();
		Users user = userService.findByName(name);
		
		model.addAttribute("tasks", taskService.findUserTask(user) );
		
		return "views/profile";
	}
	
	

}
