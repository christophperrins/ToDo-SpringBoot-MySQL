package com.qa.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String email;
	private String hashPassword;
	private String authToken;
	
	public User () {
		
	}
	
	public User (String email, String hashPassword) {
		this.email = email;
		this.hashPassword = hashPassword;
	}

	public User(String email, String hashPassword, String authToken) {
		super();
		this.email = email;
		this.hashPassword = hashPassword;
		this.authToken = authToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getAuth() {
		return authToken;
	}

	public void setAuth(String authToken) {
		this.authToken = authToken;
	}
	
	
}
