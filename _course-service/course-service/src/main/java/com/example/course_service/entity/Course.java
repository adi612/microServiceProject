package com.example.course_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Course {
	
	@Id
    @GeneratedValue
    private Long id;
	private String name;
    private String description;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
