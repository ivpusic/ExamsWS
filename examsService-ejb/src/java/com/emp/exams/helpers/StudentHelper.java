package com.emp.exams.helpers;

import com.emp.exams.models.Student;
import com.emp.exams.examsService;
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
public class StudentHelper extends DbHelper {

    /*
     * @brief Method for getting student by id
     */
    public Student searchStudentById(int id) {
        Student student = new Student();
        ResultSet rs = findRecordById(id, "Student");

        try {
            while (rs.next()) {
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setLastName(rs.getString("Lastname"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(examsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return student;
    }

    /*
     * @brief Method for getting all students
     */
    public List<Student> getAllStudentsFromDatabase() {
        List<Student> students = new ArrayList<Student>();
        Student student;
        ResultSet rs = findAllRecords("Student");
        try {
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setLastName(rs.getString("Lastname"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(examsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }
}
