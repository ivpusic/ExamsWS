
package com.emp.exams.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getExamsOfStudent", namespace = "http://exams.emp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getExamsOfStudent", namespace = "http://exams.emp.com/")
public class GetExamsOfStudent {

    @XmlElement(name = "studentId", namespace = "")
    private int studentId;

    /**
     * 
     * @return
     *     returns int
     */
    public int getStudentId() {
        return this.studentId;
    }

    /**
     * 
     * @param studentId
     *     the value for the studentId property
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
