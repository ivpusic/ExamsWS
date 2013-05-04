package com.emp.exams.models;

import java.sql.Date;

/**
 *
 * @author ivan
 */
public class Exam {

    private Student student;
    private Course course;
    private Date date;
    private String dateOfExam;
    private boolean passed;
    private Integer score;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDate(Date date) {
        this.date = date;
        this.setDateOfExam(this.date.toString());
    }

    public String getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(String dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
