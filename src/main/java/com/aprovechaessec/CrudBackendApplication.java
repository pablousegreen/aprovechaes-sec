package com.aprovechaessec;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aprovechaessec.repositories.TaskRepository;
import com.aprovechaessec.repositories.UserRepository;


@Component
public class CrudBackendApplication implements CommandLineRunner {
	private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;

    public CrudBackendApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public void run(String... args) throws Exception {
		
        // drop all hotels
		System.out.println("**************DELETE ALL FROM USERS**************");
        this.userRepository.deleteAll();
		this.taskRepository.deleteAll();
	}
}
