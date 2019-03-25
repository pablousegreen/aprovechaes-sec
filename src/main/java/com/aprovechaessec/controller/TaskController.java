package com.aprovechaessec.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.User;
import com.aprovechaessec.services.TaskService;
import com.aprovechaessec.services.UserService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session) {		
		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		return "views/taskForm";
	}
	
	@PostMapping("/addTask")
	public String addTask(@Valid Task task, BindingResult bindingResult, Model model, HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "views/taskForm";
		}
		String email = (String)session.getAttribute("email");
//		taskService.addTask(task, taskService.findUserTask(userService.findOne(email)).get(0));	
		User user = userService.findOne(email);
		if (user != null) {
			taskService.addTask(task, user);	
		}else {
			model.addAttribute("notUser", false);
			return "views/taskForm";
		}
		return "redirect:/users";
	}
}
