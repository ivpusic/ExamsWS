
package com.emp.exams.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCourseByIdResponse", namespace = "http://exams.emp.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCourseByIdResponse", namespace = "http://exams.emp.com/")
public class GetCourseByIdResponse {

    @XmlElement(name = "return", namespace = "")
    private com.emp.exams.models.Course _return;

    /**
     * 
     * @return
     *     returns Course
     */
    public com.emp.exams.models.Course getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.emp.exams.models.Course _return) {
        this._return = _return;
    }

}
