package com.example.student_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.student_service.Entity.student;
import com.example.student_service.client.CourseRestClient;
import com.example.student_service.repository.StudentRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/students")
@Tag(name = "Student API", description = "Operations for managing students and their courses")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRestClient courseRestClient;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> getStudentWithCourse(@PathVariable Long id) {
        logger.info("Fetching student with ID: {}", id);
        student student = studentRepo.findById(id).orElse(null);
        if (student == null) {
            logger.warn("Student with ID {} not found", id);
            return Map.of("error", "Student not found");
        }

        logger.info("Student found: {}", student.getName());

        Map<String, Object> response = new HashMap<>();
        response.put("student", student);
        return response;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public student addStudent(@RequestBody student student) {
        logger.info("Adding new student: {}", student.getName());
        return studentRepo.save(student);
    }

    @GetMapping("/only/{id}")
    public student getStudentOnly(@PathVariable Long id) {
        logger.info("Fetching student (no auth) with ID: {}", id);
        return studentRepo.findById(id).orElse(null);
    }
}
