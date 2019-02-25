package com.aprovechaessec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.User;
import com.aprovechaessec.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired 
	private TaskRepository taskRepository;
	
	public void addTask(Task task) {
		taskRepository.save(task);
	}
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTask(User user){
		return taskRepository.findByUser(user);
	}
}
