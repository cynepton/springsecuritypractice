package com.findisaac.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Student Controller class
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    /**
     * Dummy list of students
     */
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Keanu Reeves"),
            new Student(3, "Reese Witherspoon")
    );

    /**
     * Controller: /{studentId}
     * Get student by ID
     * @param studentId The student ID
     * @return The student object with the sent ID
     */
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Student " + studentId + " does not exist."
                ));
    }
}
