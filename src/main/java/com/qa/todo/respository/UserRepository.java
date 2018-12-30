package com.qa.todo.respository;

import org.springframework.data.repository.CrudRepository;

import com.qa.todo.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
