package com.qa.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserTasks {

	private String authToken;
	@Id
	private String uuid;
	
	public UserTasks () {
		
	}
	
	public UserTasks(String authToken, String uuid) {
		super();
		this.authToken = authToken;
		this.uuid = uuid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
