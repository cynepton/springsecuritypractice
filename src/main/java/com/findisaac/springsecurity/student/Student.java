package com.findisaac.springsecurity.student;

/**
 * Student Model Class
 */
public class Student {

    private final Integer studentId;
    private final String studentName;

    /**
     * Student Class constructor
     * @param studentId The Unique student identifier
     * @param studentName The student name
     */
    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    /**
     * Getter function for the student ID
     * @return The student Integer ID
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Getter function for the student name
     * @return The student name
     */
    public String getStudentName() {
        return studentName;
    }

}
