package com.qa.todo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.todo.model.Task;
import com.qa.todo.model.UserTasks;
import com.qa.todo.respository.TaskRepository;
import com.qa.todo.respository.UserTasksRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserTasksRepository userTasksRepository;
	
	public Iterable<Task> getTasks(String apikey) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		ArrayList<String> taskIds = new ArrayList<String>();
		
		for(UserTasks userTasks : userTasksRepository.findAll()) {
			if( userTasks.getAuthToken().equals(apikey) ) {
				taskIds.add(userTasks.getUuid());
			}
		}
		
		for(String taskId : taskIds) {
			tasks.add(taskRepository.findById(taskId).get());
		}		
		
		return tasks;
	}
	
	public Iterable<Task> postTask(@RequestBody Task task, String apikey) {
		if (taskRepository.existsById(task.getIdentifier())) {
			return null;
		}	
		UserTasks userTasks = new UserTasks(apikey, task.getIdentifier());
		userTasksRepository.save(userTasks);
		taskRepository.save(task);
		return getTasks(apikey);
	}
	
	public Iterable<Task> putTask(@RequestBody Task newTask, @PathVariable String identifier, String apikey) {
		if(!userTasksRepository.findById(identifier).get().getAuthToken().equals(apikey)) {
			return null;
		}
		
		Task task = taskRepository.findById(identifier).get();
		task.setText(newTask.getText());
		taskRepository.save(task);
		return getTasks(apikey);
	}
	
	public Iterable<Task> deleteTask(@PathVariable String identifier, String apikey) {
		if(!userTasksRepository.findById(identifier).get().getAuthToken().equals(apikey)) {
			return null;
		}
		Task task = taskRepository.findById(identifier).get();
		taskRepository.delete(task);
		return getTasks(apikey);
	}
}
