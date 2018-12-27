package com.qa.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Tasks")
public class Task {

	@Id
	private String identifier;
	private String text;
	
	public Task () {
		
	}
	
	public Task(String identifier, String text) {
		this.identifier = identifier;
		this.text = text;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
