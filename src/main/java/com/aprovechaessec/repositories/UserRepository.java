package com.aprovechaessec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aprovechaessec.entity.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{

	Optional<Users> findByEmail(String email);

	//List<User> findByNameLike(String name);
	
	List<Users> findByNameStartingWith(String regexp);
//	public User findById( final String id );
	
}
