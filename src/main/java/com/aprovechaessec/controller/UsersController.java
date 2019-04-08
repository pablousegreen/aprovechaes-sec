package com.aprovechaessec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aprovechaessec.services.UserServiceImpl;

@Controller
public class UsersController {
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/users")
	public String listUsers(Model model, @RequestParam(defaultValue="") String name) {
		if(name == null || name.length()<=0) {
			model.addAttribute("users", userService.getFindAll());
			return "views/listUsers";
		}
		
		model.addAttribute("users", userService.findByName(name));
//		model.addAttribute("users", userService.findUsersByRegexpName(name));
		return "views/listUsers";
	}

}
