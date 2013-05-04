
package com.emp.exams.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllStudentsWhichAreNotPassedExam", namespace = "http://exams.emp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllStudentsWhichAreNotPassedExam", namespace = "http://exams.emp.com/")
public class GetAllStudentsWhichAreNotPassedExam {

    @XmlElement(name = "courseId", namespace = "")
    private int courseId;

    /**
     * 
     * @return
     *     returns int
     */
    public int getCourseId() {
        return this.courseId;
    }

    /**
     * 
     * @param courseId
     *     the value for the courseId property
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
