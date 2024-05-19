package com.spring.coursebackend.servies;

import com.spring.coursebackend.dao.CourseDao;
import com.spring.coursebackend.entity.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseServicesImplematationTest {

    @InjectMocks
    private CourseServicesImplematation courseServicesImplematation;

    @Mock
    private CourseDao courseDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Completed");

    }

    @Test
    void getCourses_Test() {
        Course course1 = new Course(1L, "Java", "Java Basics");
        Course course2 = new Course(2L, "Spring", "Spring Basics");
        Course course3 = new Course(3L, "Spring Boot", "Spring Boot Basics");
        when(courseDao.findAll()).thenReturn(List.of(course1, course2, course3));
        List<Course> courses = courseServicesImplematation.getCourses();
        assertEquals(3, courses.size());
        verify(courseDao).findAll();
    }

    @Test
    void getCourseById_Test() {
        when(courseDao.getById(1L)).thenReturn(new Course(1L, "Java", "Java Basics"));
        Course course = courseServicesImplematation.getCourse(1L);
        assertEquals(1L, course.getId());
        assertEquals("Java", course.getTitle());
        verify(courseDao).getById(1L);
    }

    @Test
    void addCourse_Test() {
        Course course = new Course(1L, "Java", "Java Basics");
        when(courseDao.save(course)).thenReturn(course);
        Course savedCourse = courseServicesImplematation.addCourse(course);
        assertEquals(1L, savedCourse.getId());
        verify(courseDao).save(course);
    }

    @Test
    void updateCourse_Test() {
        Course course = new Course(1L, "python", "Python Basics");
        when(courseDao.getById(1L)).thenReturn(new Course(1L, "python", "Python Basics"));
        when(courseDao.save(course)).thenReturn(course);

        Course updatedCourse = courseServicesImplematation.updateCourse(course, 1L);
        assertEquals("python", updatedCourse.getTitle());
        assertEquals("Python Basics", updatedCourse.getDescription());
        verify(courseDao).save(course);
    }

    @Test
    void deleteCourse_Test() {
        Course course = new Course(1L, "Java", "Java Basics");

        when(courseDao.getById(1L)).thenReturn(course);
        doNothing().when(courseDao).delete(course);

        courseServicesImplematation.deleteCourse(1L);
        verify(courseDao).delete(course);

    }
}