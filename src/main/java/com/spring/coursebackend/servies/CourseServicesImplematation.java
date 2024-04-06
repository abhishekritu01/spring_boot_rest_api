package com.spring.coursebackend.servies;
import java.util.List;
import java.util.ArrayList;
import com.spring.coursebackend.entity.Course;

import com.spring.coursebackend.entity.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseServicesImplematation implements CourseService {
    List<Course> list;
    public CourseServicesImplematation() {
        list = new ArrayList<>();
        list.add(new Course(1L, "Java", "Java Description"));
        list.add(new Course(2L, "Spring", "Spring Description"));
        list.add(new Course(3L, "Spring Boot", "Spring Boot Description"));
        list.add(new Course(4L, "React", "React Description"));
        list.add(new Course(5L, "Angular", "Angular Description"));
        list.add(new Course(6L, "Vue", "Vue Description"));
        list.add(new Course(7L, "Node", "Node Description"));
        list.add(new Course(8L, "MongoDB", "MongoDB Description"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course, long courseId) {
        Course c = null;
        for (Course course2 : list) {
            if (course2.getId() == courseId) {
                course2.setTitle(course.getTitle());
                course2.setDescription(course.getDescription());
                c = course2;
                break;
            }
        }
        return c;
    }

    @Override
    public void deleteCourse(long courseId) {
        list = this.list.stream().filter(e -> e.getId() != courseId).toList();
    }
}
