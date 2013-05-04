
package com.emp.exams.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllStudentsResponse", namespace = "http://exams.emp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllStudentsResponse", namespace = "http://exams.emp.com/")
public class GetAllStudentsResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.emp.exams.models.Student> _return;

    /**
     * 
     * @return
     *     returns List<Student>
     */
    public List<com.emp.exams.models.Student> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.emp.exams.models.Student> _return) {
        this._return = _return;
    }

}
