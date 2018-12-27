package com.qa.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo.model.Task;
import com.qa.todo.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping (value = "tasks", method = RequestMethod.GET)
	public Iterable<Task> getAllTasks() {
		return taskService.getTasks();
	}
	
	@RequestMapping (value = "tasks", method = RequestMethod.POST)
	public Iterable<Task> addTask(@RequestBody Task task) {
		return taskService.postTask(task);
	}
	
	@RequestMapping (value = "tasks/{identifier}", method = RequestMethod.PUT)
	public Iterable<Task> updateTask(@RequestBody Task task, @PathVariable String identifier) {
		return taskService.putTask(task, identifier);
	}
	
	@RequestMapping (value = "tasks/{identifier}", method = RequestMethod.DELETE)
	public Iterable<Task> deleteTask(@PathVariable String identifier) {
		return taskService.deleteTask(identifier);
	}
	
}
