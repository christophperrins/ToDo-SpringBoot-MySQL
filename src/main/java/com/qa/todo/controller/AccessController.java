	package com.qa.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo.model.User;
import com.qa.todo.service.AccessService;

@RestController
public class AccessController {
	
	@Autowired
	private AccessService accessService;

	@RequestMapping (value = "signup", method = RequestMethod.POST)
	public String getAuthToken(@RequestBody User user) {
		return accessService.getAuthToken(user);
	}
}
