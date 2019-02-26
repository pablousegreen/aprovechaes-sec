package com.aprovechaessec.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.aprovechaessec.entity.User;
import com.aprovechaessec.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired 
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", new User());		
		return "views/registerForm";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors() || user == null) {
			return "views/registerForm";
		}
		
		if(userService.isUserPresent(user.getEmail().trim().toLowerCase())) {
			model.addAttribute("exist", true);
			model.addAttribute("user", user);	
			return "views/registerForm";
		}		
		userService.creatUser(user);
		return "views/success";
	}
}
