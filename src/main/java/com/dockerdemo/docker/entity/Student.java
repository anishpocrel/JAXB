package com.dockerdemo.docker.entity;

import com.dockerdemo.docker.adapter.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * @author Anish Pokhrel
 * @version 1.0.0
 * @since 1.0.0 - 2021/06/17 10:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlType(propOrder = {"id","name","roll","address","appointedDate"})
public class Student {

    private Integer id;
    private Integer roll;
    private String name;
    private String address;
    private Date appointedDate;

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoll() {
        return roll;
    }

    @XmlAttribute(name="roll")
    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAppointedDate() {
        return appointedDate;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "appointeddate")
    public void setAppointedDate(Date appointedDate) {
        this.appointedDate = appointedDate;
    }
}
