package edu.ku.bookapi.controller;

import edu.ku.bookapi.model.Course;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {

    private final List<Course> courses = List.of(
            new Course(1L, "EWA301", "Enterprise Web App", 3),
            new Course(2L, "DB201", "Database Systems", 3),
            new Course(3L, "SE202", "Software Engineering", 3)
    );

    @GetMapping
    public List<Course> getCourses() {
        return courses;
    }
}