package com.example.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_service.Entity.student;

public interface StudentRepository extends JpaRepository<student, Long> {
	
}

