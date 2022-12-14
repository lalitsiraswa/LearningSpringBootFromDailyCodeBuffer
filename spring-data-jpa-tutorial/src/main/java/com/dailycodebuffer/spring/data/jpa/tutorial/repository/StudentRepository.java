package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String guardianName);
     Student findByFirstNameAndLastName(String firstName, String lastName);

     // JPQL Query (JPQL queries are based on the Classes that you created not on the tables that are stored in DataBase)
     // that's why we are using Student instead of tbl_student and Student class attributes like emailId not email_address
     // of tbl_student table
     @Query("select s from Student s where s.emailId = ?1")
     Student getStudentByEmailAddress(String emailId);

     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getStudentFirstNameByEmailAddress(String emailId);

     // Native Query
     @Query(
             value = "SELECT * FROM tbl_student s where s.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String emailId);

     // Native Named Param
     @Query(
             value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

     // The same @Annotations will be applicable when you want you delete the record
     @Modifying
     @Transactional
     @Query(
             value = "update tbl_student set first_name = ?1 where email_address = ?2",
             nativeQuery = true
     )
     int updateStudentNameByEmailId(String firstName, String emailId);
}
