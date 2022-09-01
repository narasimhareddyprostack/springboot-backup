package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.Task;
import com.task.service.TaskService;


@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	//Rest API
	
	//1.localhost:8989/App/task
	@GetMapping("/task")
	public List getAllTask() {
		return taskService.getAllTask();
	}
	//2.localhost:8989/App/add
	@PostMapping(value="/add", consumes="application/json")
	public void addNewTask(@RequestBody Task task) {
		System.out.println(task+"test case 123");
		taskService.addTask(task);
	}
	//3.localhost:8989/App/update
	@PutMapping(value="/update/{id}", consumes="application/json")
	public void updateTask(@PathVariable  String id, @RequestBody Task task) {
		System.out.println(task.getName()+"Test Case 124");
		taskService.upateTask(task);
	}
}
