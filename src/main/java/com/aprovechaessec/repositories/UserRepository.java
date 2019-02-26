package com.aprovechaessec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aprovechaessec.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByEmail(String email);

	//List<User> findByNameLike(String name);
	
	List<User> findByNameStartingWith(String regexp);
//	public User findById( final String id );
}
