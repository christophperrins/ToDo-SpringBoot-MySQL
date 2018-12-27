package com.qa.todo.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.todo.model.Task;
import com.qa.todo.respository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Iterable<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	public Iterable<Task> postTask(@RequestBody Task task) {
		taskRepository.save(task);
		return getTasks();
	}
	
	public Iterable<Task> putTask(@RequestBody Task newTask, @PathVariable String identifier) {
		Task task = taskRepository.findById(identifier).get();
		task.setText(newTask.getText());
		taskRepository.save(task);
		return getTasks();
	}
	
	public Iterable<Task> deleteTask(@PathVariable String identifier) {
		Task task = taskRepository.findById(identifier).get();
		taskRepository.delete(task);
		return getTasks();
	}
}
