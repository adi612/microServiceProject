package com.example.course_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.course_service.entity.Course;
import com.example.course_service.repositary.CourseRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/courses")
@Tag(name = "Course API", description = "Operations for managing courses")
public class CourseController {

    @Autowired
    private CourseRepository repo;

    @GetMapping("/{id}")
    @Operation(summary = "Get Course by ID", description = "Fetch a course by its ID")
    public Course getCourse(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Add New Course", description = "Add a new course to the database")
    public Course addCourse(@RequestBody Course course) {
        return repo.save(course);
    }
}
