package com.spring.coursebackend.controller;

import com.spring.coursebackend.entity.Course;
import com.spring.coursebackend.servies.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MyController {

    @Autowired         // means we are injecting the dependency of CourseService
    private CourseService courseService;

    @GetMapping("/api/v1/course")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    @GetMapping("/api/v1/course/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
       return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/api/v1/course")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }


    @PutMapping("/api/v1/course/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable String courseId){
        return this.courseService.updateCourse(course, Long.parseLong(courseId));
    }

    @DeleteMapping("/api/v1/course/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        this.courseService.deleteCourse(Long.parseLong(courseId));
    }

}
