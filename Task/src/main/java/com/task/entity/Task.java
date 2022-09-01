package com.task.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity	
public class Task {
	
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer Id;
	
	private String name;
	private String assignTo;
	public Task() {
		
	}
	
	
	public Task(Integer id, String name, String assignTo) {
		super();
		Id = id;
		this.name = name;
		this.assignTo = assignTo;
	}


	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	
	
	
	
}
