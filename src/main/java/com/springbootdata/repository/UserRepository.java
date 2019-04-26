package com.springbootdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.springbootdata.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {
	
	User findByEmail(String email);
	
	User findByNomeIgnoreCase(String nome);
}
