package com.springbootdata.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String id;
	private String nome;
	private String email;
	private Set<Role> roles;
	
	
	//Constructor's
	public User() {
		super();
	}
	
	public User(String id, String nome, String email, Set<Role> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.roles = roles;
	}

	public User(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}


	// Getter's and Setter's
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
