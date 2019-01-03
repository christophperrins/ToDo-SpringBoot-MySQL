package com.qa.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo.model.Task;
import com.qa.todo.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping (value = "tasks", method = RequestMethod.GET)
	public Iterable<Task> getAllTasks(@RequestParam(value="apikey", required=true) String apikey) {
		System.out.println("controllerGet");
		return taskService.getTasks(apikey);
	}
	
	@RequestMapping (value = "tasks", method = RequestMethod.POST)
	public Iterable<Task> addTask(@RequestBody Task task, @RequestParam(value="apikey", required=true) String apikey) {
		System.out.println("controllerPost");
		return taskService.postTask(task, apikey);
	}
	
	@RequestMapping (value = "tasks/{identifier}", method = RequestMethod.PUT)
	public Iterable<Task> updateTask(@RequestBody Task task, @PathVariable String identifier, @RequestParam(value="apikey", required=true) String apikey) {
		System.out.println("controllerPut");
		return taskService.putTask(task, identifier, apikey);
	}
	
	@RequestMapping (value = "tasks/{identifier}", method = RequestMethod.DELETE)
	public Iterable<Task> deleteTask(@PathVariable String identifier, @RequestParam(value="apikey", required=true) String apikey) {
		System.out.println("controllerDelete");
		return taskService.deleteTask(identifier, apikey);
	}
	
}
