package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseDbms = Course.builder()
                .title("DBMS")
                .credit(8)
                .build();
        Course courseJava = Course.builder()
                .title("JAVA")
                .credit(9)
                .build();
        Course courseOperatingSystem = Course.builder()
                .title("Operating System")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("farhan")
                .lastName("Khan")
                .courses(List.of(courseDbms, courseJava, courseOperatingSystem))
                .build();
        teacherRepository.save(teacher);
    }
}