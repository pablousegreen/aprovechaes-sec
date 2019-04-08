package com.aprovechaessec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.Users;
import com.aprovechaessec.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired 
	private TaskRepository taskRepository;
	
	public void addTask(Task task) {
		taskRepository.save(task);
	}
	
	public void addTask(Task task, Users user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTask(Users user){
		return taskRepository.findByUser(user);
	}
}
