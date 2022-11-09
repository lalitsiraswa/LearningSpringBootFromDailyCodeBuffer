package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3); // TotalPages : 2 because each page contains 3 records, and total records are 6
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2); // TotalPages : 3 because each page contains 2 records, and total records are 6
        Pageable thirdPageWithOneRecords = PageRequest.of(2, 1); // TotalPages : 6 because each page contains 1 records, and total records are 6
        Pageable fourthPageWithOneRecords = PageRequest.of(3, 1); // TotalPages : 6 because each page contains 1 records, and total records are 6

//        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
//        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
//        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

//        List<Course> courses = courseRepository.findAll(thirdPageWithOneRecords).getContent();
//        Long totalElements = courseRepository.findAll(thirdPageWithOneRecords).getTotalElements();
//        long totalPages = courseRepository.findAll(thirdPageWithOneRecords).getTotalPages();
        System.out.println("totalPages : " + totalPages);
        System.out.println("totalElements : " + totalElements);
        System.out.println("courses : " + courses);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit").descending()));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses : " + courses);
    }
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecord = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecord).getContent();
        System.out.println("courses : " + courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Abhinav")
                .lastName("Sharma")
                .build();
        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Kumar")
                .emailId("abhishekkumar@gmail.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}