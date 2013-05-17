package com.emp.exams;

import com.emp.exams.helpers.CourseHelper;
import com.emp.exams.helpers.ExamHelper;
import com.emp.exams.helpers.StudentHelper;
import com.emp.exams.models.Course;
import com.emp.exams.models.Exam;
import com.emp.exams.models.Student;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author ivan
 */
@WebService(serviceName = "examsService")
@Stateless()
public class examsService {

    StudentHelper studentHelper;
    CourseHelper courseHelper;
    ExamHelper examHelper;

    /*
     * Constructor
     */
    public examsService() {
        studentHelper = new StudentHelper();
        courseHelper = new CourseHelper();
        examHelper = new ExamHelper();
    }

    /**
     * Search for student in database by given studentId
     */
    @WebMethod(operationName = "getStudentById")
    public Student getStudentById(@WebParam(name = "studentId") int studentId) {
        return studentHelper.searchStudentById(studentId);
    }

    /**
     * Method for retriving all students from database
     */
    @WebMethod(operationName = "getAllStudents")
    public List<Student> getAllStudents() {
        return studentHelper.getAllStudentsFromDatabase();
    }

    /**
     * Search for course by id
     */
    @WebMethod(operationName = "getCourseById")
    public Course getCourseById(@WebParam(name = "courseId") int courseId) {
        return courseHelper.searchCourseById(courseId);
    }

    /**
     * Method for retriving all courses from database
     */
    @WebMethod(operationName = "getAllCourses")
    public List<Course> getAllCourses() {
        return courseHelper.getAllCoursesFromDatabase();
    }

    /**
     * Method for getting all exams of some student
     */
    @WebMethod(operationName = "getExamsOfStudent")
    public List<Exam> getExamsOfStudent(@WebParam(name = "studentId") int studentId) {
        return examHelper.getAllExamsFromDatabaseForStudent(studentId);
    }

    /**
     * Method for getting all student on some exam
     */
    @WebMethod(operationName = "getAllStudentsOnExam")
    public List<Student> getAllStudentsOnExam(@WebParam(name = "courseId") int courseId) {
        return examHelper.getAllStudentsFromDatabaseOnExam(courseId);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllStudentsWhichArePassedExam")
    public List<Exam> getAllStudentsWhichArePassedExam(@WebParam(name = "courseId") int courseId) {
        return examHelper.getAllPassedStudentsOnExamFromDatabase(courseId, 1);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllStudentsWhichAreNotPassedExam")
    public List<Exam> getAllStudentsWhichAreNotPassedExam(@WebParam(name = "courseId") int courseId) {
        return examHelper.getAllPassedStudentsOnExamFromDatabase(courseId, 0);
    }
}
