package com.example.student_service.client;

import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestClient;
//import com.example.course_service.entity.Course;

@Service
public class CourseRestClient {

    private final RestClient restClient;

    public CourseRestClient() {
        this.restClient = RestClient.builder()
            .baseUrl("http://localhost:8081") // 
            .build();
    }

//    public Course getCourseById(Long id) {
//        return restClient.get()
//                .uri("/courses/{id}", id)
//                .retrieve()
//                .body(Course.class);
//    }
}
