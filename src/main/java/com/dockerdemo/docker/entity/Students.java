package com.dockerdemo.docker.entity;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Anish Pokhrel
 * @version 1.0.0
 * @since 1.0.0 - 2021/06/17 11:08
 */
@Data
@XmlRootElement(name = "college")
@XmlType(propOrder = {"collegeid","students"})
public class Students {

    private Integer collegeid;
    List<Student> students;

    @XmlAttribute
    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    @XmlElement
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
