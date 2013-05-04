package com.emp.exams.helpers;

import com.emp.exams.models.Exam;
import com.emp.exams.models.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class ExamHelper extends DbHelper {

    StudentHelper studentHelper;
    CourseHelper courseHelper;

    public ExamHelper() {
        studentHelper = new StudentHelper();
        courseHelper = new CourseHelper();
    }

    /*
     * @brief Method for getting all exams for some student
     */
    public List<Exam> getAllExamsFromDatabaseForStudent(int studentId) {
        ResultSet rs = findRecordByForeignKey("Exam", "Student_id", studentId);
        List<Exam> exams = new ArrayList<Exam>();
        Exam exam;

        try {
            while (rs.next()) {
                exam = new Exam();
                exam.setPassed(rs.getBoolean("Passed"));
                if (exam.isPassed()) {
                    exam.setScore(rs.getInt("Score"));
                } else {
                    exam.setScore(null);
                }
                exam.setDate(rs.getDate("Date"));
                exam.setCourse(courseHelper.searchCourseById(rs.getInt("Course_id")));

                exams.add(exam);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exams;
    }

    /*
     * @brief Method for getting all students which are taking some exam
     */
    public List<Student> getAllStudentsFromDatabaseOnExam(int courseId) {
        ResultSet rs = findRecordByForeignKey("Exam", "Course_id", courseId);
        List<Student> studentsOnExam = new ArrayList<Student>();
        Student student;

        try {
            while (rs.next()) {
                student = studentHelper.searchStudentById(rs.getInt("Student_id"));
                studentsOnExam.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentsOnExam;
    }

    public List<Exam> getAllPassedStudentsOnExamFromDatabase(int courseId, int isPassed) {
        ResultSet rs = findRecordByForeignKey("Exam", "Course_id", courseId, "passed", isPassed);
        List<Exam> exams = new ArrayList<Exam>();
        Exam exam;

        try {
            while (rs.next()) {
                exam = new Exam();
                exam.setPassed(rs.getBoolean("Passed"));
                if (exam.isPassed()) {
                    exam.setScore(rs.getInt("Score"));
                } else {
                    exam.setScore(null);
                }
                exam.setDate(rs.getDate("Date"));
                exam.setStudent(studentHelper.searchStudentById(rs.getInt("Student_id")));

                exams.add(exam);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exams;
    }
}