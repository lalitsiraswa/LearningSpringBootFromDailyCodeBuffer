package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("rameshkumar@gmail.com")
                .firstName("Ramesh")
                .lastName("Kumar")
                // .guardianName("Siraswa")
                // .guardianEmail("siraswa@gmail.com")
                // .guardianMobile("7684756738")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Sheetal Sharma")
                .email("sheetalsharma@gmail.com")
                .mobile("8693748576")
                .build();
        Student student = Student.builder()
                .firstName("Nidhi")
                .emailId("nidhi_sharma@gmail.com")
                .lastName("")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Ramesh");
        System.out.println("studentList : " + studentList);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("vik");
        System.out.println("studentList : " + studentList);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList : " + studentList);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Nikhil");
        System.out.println("studentList : " + studentList);
    }
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("nidhi_sharma@gmail.com");
        System.out.println("student : " + student);
    }
    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("nidhi_sharma@gmail.com");
        System.out.println("Student First Name : " + studentFirstName);
    }
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("nidhi_sharma@gmail.com");
        System.out.println("student : " + student);
    }
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("nidhi_sharma@gmail.com");
        System.out.println("student : " + student);
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Rakesh", "siraswa@gmail.com");
    }
}