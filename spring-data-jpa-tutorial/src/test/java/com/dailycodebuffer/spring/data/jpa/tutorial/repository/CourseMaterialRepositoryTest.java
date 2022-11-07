package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void saveCourseMaterial(){
        Course course =
                Course.builder()
                        .title("DSA")
                        .credit(6)
                        .build();
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.google.com")
                        .course(course)
                        .build();
        courseMaterialRepository.save(courseMaterial);
    }
}