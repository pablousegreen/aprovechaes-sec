package com.aprovechaessec.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.aprovechaessec.entity.Users;
import com.aprovechaessec.services.UserServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired 
	private UserServiceImpl userService;

	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", new Users());		
		return "views/registerForm";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid Users user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors() || user == null) {
			return "views/registerForm";
		}
		
		if(userService.isUserPresent(user.getEmail().trim().toLowerCase())) {
			model.addAttribute("exist", true);
			model.addAttribute("user", user);	
			return "views/registerForm";
		}		
		userService.creatAdmin(user);
		return "views/success";
	}
}
