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
		System.out.println("get1");
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		ArrayList<String> taskIds = new ArrayList<String>();
		
		for(UserTasks userTasks : userTasksRepository.findAll()) {
			if( userTasks.getAuthToken().equals(apikey) ) {
				taskIds.add(userTasks.getUuid());
			}
		}
		System.out.println("get2");
		
		for(String taskId : taskIds) {
			tasks.add(taskRepository.findById(taskId).get());
		}		
		System.out.println("get3");
		
		return tasks;
	}
	
	public Iterable<Task> postTask(@RequestBody Task task, String apikey) {
		System.out.println("post1");
		if (taskRepository.existsById(task.getIdentifier())) {
			return null;
		}	
		System.out.println("post2");
		UserTasks userTasks = new UserTasks(apikey, task.getIdentifier());
		System.out.println("post3");
		userTasksRepository.save(userTasks);
		System.out.println("post4");
		taskRepository.save(task);
		System.out.println("post5");
		return getTasks(apikey);
	}
	
	public Iterable<Task> putTask(@RequestBody Task newTask, @PathVariable String identifier, String apikey) {
		System.out.println("put1");
		if(!userTasksRepository.findById(identifier).get().getAuthToken().equals(apikey)) {
			return null;
		}
		System.out.println("put2");
		Task task = taskRepository.findById(identifier).get();
		System.out.println("put3");
		task.setText(newTask.getText());
		System.out.println("put4");
		taskRepository.save(task);
		System.out.println("put5");
		return getTasks(apikey);
	}
	
	public Iterable<Task> deleteTask(@PathVariable String identifier, String apikey) {
		System.out.println("delete1");
		if(!userTasksRepository.findById(identifier).get().getAuthToken().equals(apikey)) {
			return null;
		}
		System.out.println("delete2");
		Task task = taskRepository.findById(identifier).get();
		System.out.println("delete3");
		taskRepository.delete(task);
		System.out.println("delete4");
		return getTasks(apikey);
	}
}
