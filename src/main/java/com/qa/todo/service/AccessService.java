package com.qa.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.todo.Utils;
import com.qa.todo.model.User;
import com.qa.todo.respository.UserRepository;

@Service
public class AccessService {

	@Autowired
	private UserRepository userRepository;
	
	public String getAuthToken(@RequestBody User user) {
		if(!userRepository.existsById(user.getEmail())) {
			String auth = Utils.sha256(user.getEmail() + "extra" + user.getHashPassword() + "bits");
			user.setAuth(auth);
			userRepository.save(user);
			return auth;
		}
		else return "User Exists";
	}
}
