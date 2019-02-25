package com.aprovechaessec.services;

import java.util.List;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.User;

public interface TaskService {
	public void addTask(Task task);
	public void addTask(Task task, User user);
	public List<Task> findUserTask(User user);
}
