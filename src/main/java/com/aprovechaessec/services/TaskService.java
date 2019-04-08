package com.aprovechaessec.services;

import java.util.List;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.Users;

public interface TaskService {
	public void addTask(Task task);
	public void addTask(Task task, Users user);
	public List<Task> findUserTask(Users user);
}
