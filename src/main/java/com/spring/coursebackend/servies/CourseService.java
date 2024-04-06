package com.spring.coursebackend.servies;

import com.spring.coursebackend.entity.Course;
import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(long courseId);

    Course addCourse(Course course);

    Course updateCourse(Course course, long courseId);

    void deleteCourse(long courseId);
}
