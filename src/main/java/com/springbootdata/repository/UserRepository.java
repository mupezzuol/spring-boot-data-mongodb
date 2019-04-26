package com.springbootdata.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springbootdata.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {
	
	User findByEmail(String email);
	
	//Da mesma forma que crio querys normais, porém '?0' para ordem dos parametros
	@Query("{ 'nome' : ?0 }")
	User findByNomeQualquerCoisa(String n);
	
	User findByNomeIgnoreCase(String nome);
	
	List<User> findByNomeIgnoreCaseLike(String nome);
	
	List<User> findByIdadeGreaterThanEqual(int idade);
}
