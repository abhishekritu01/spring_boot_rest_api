package com.spring.coursebackend.dao;

import com.spring.coursebackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {


}
