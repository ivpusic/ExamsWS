package com.emp.exams.helpers;

import com.emp.exams.examsService;
import com.emp.exams.models.Course;
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
public class CourseHelper extends DbHelper {
    /*
     * @brief Method for getting courses by id
     */
    public Course searchCourseById(int id) {
        Course course = new Course();
        ResultSet rs = findRecordById(id, "Course");

        try {
            while (rs.next()) {
                course.setId(rs.getInt("Id"));
                course.setName(rs.getString("Name"));
                course.setEcts(rs.getInt("Ects"));
                course.setSemester(rs.getInt("Semester"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(examsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return course;
    }

    /*
     * @brief Method for getting all students
     */
    public List<Course> getAllCoursesFromDatabase() {
        List<Course> courses = new ArrayList<Course>();
        Course course;
        ResultSet rs = findAllRecords("Course");
        try {
            while (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("Id"));
                course.setName(rs.getString("Name"));
                course.setEcts(rs.getInt("Ects"));
                course.setSemester(rs.getInt("Semester"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(examsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return courses;
    }
}
