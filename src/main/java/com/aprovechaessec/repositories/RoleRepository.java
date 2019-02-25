package com.aprovechaessec.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aprovechaessec.entity.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

}
