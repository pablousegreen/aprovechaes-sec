package com.aprovechaessec.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aprovechaessec.entity.Task;
import com.aprovechaessec.entity.User;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

	List<Task> findByUser(User user);

}
