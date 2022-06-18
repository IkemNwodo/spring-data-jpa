package com.ikem.spring.data.jpa.tutorial.repository;

import com.ikem.spring.data.jpa.tutorial.entity.Course;
import com.ikem.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses() {
        List<Course> courses =
                repository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher =
                Teacher.builder()
                        .firstName("Nonye")
                        .lastName("Ikemefuna")
                        .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Course> courses =
                repository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                repository.findAll(secondPageWithTwoRecords)
                                .getTotalElements();

        long totalPages =
                repository.findAll(secondPageWithTwoRecords)
                                .getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }
}