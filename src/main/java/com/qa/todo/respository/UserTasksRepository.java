package com.qa.todo.respository;

import org.springframework.data.repository.CrudRepository;

import com.qa.todo.model.UserTasks;

public interface UserTasksRepository extends CrudRepository<UserTasks, String>{

}
