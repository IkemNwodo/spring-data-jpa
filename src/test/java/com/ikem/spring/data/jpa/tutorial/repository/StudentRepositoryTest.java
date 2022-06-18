package com.ikem.spring.data.jpa.tutorial.repository;

import com.ikem.spring.data.jpa.tutorial.entity.Guardian;
import com.ikem.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("nwodo@gmail.com")
                .firstName("Ikem")
                .lastName("Nwodo")
                //.guardianName("Ifeoma")
                //.guardianEmail("Ifeoma@gmail.com")
                //.guardianMobile("1111111111")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Ifeoma")
                .mobile("2222222222")
                .email("ifeoma@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Ikemefuna")
                .lastName("Nwodo")
                .emailId("Nwodofrank@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students =
                studentRepository.findByFirstName("Ikemefuna");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("Ike");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {

        List<Student> students =
                studentRepository.findByGuardianName("Ifeoma");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastNameNotNull() {

        List<Student> students =
                studentRepository.findByLastNameNotNull();

        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "nwodo@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "Nwodofrank@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "nwodo@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "nwodo@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        int returnValue = studentRepository
                .updateStudentNameByEmailId(
                        "Ikem",
                        "nwodofrank@gmail.com"
                );

        System.out.println("returnValue = " + returnValue);
    }
    
}