package com.example.student_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class student {
    @Id
    @GeneratedValue
    private Long id;
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
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	private String name;
    private Long courseId;
    
	public student(Long id, String name, Long courseId) {
		super();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

