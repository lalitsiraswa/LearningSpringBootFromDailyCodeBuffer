package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses " + courses);
    }
    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher = Teacher.builder()
                .firstName("Kunal")
                .lastName("kushwaha")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}