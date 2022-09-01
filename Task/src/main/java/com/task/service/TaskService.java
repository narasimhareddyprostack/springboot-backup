package com.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.Task;
import com.task.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	//Performing CRUD Operations
	//1.Get All Task   - Read
	public List	 getAllTask() {
		List<Task> tasks = new ArrayList();
		taskRepo.findAll().forEach(tasks::add);
		return tasks;
	}
	//2.add Task    - create
	public void addTask(Task task){
		taskRepo.save(task);
	}
	//3. udpate Task  - update
	public void upateTask(Task task) {
		taskRepo.save(task);
	}
	//4. delete Task - delete
	public void deleteTask(String id) {
		taskRepo.deleteById(id);
	}
}
