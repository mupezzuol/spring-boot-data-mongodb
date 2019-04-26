package com.springbootdata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {

	@Id
	private String id;
	private String name;
	
	//Constructor's
	public Role() {
		super();
	}
	
	public Role(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Getter's and Setter's
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}