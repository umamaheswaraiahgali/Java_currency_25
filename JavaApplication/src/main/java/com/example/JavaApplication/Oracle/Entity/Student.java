package com.example.JavaApplication.Oracle.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {

    @Id
    private int rollnum;
    @Column(name="FIRSTNAME")
    private String studentFirstName;
    @Column(name="LASTNAME")
    private String studentLastName;
    @Column(name="ADDRESS")
    private  String studentAddress;
    @Column(name="CITY")
    private String studentCity;

    public int getRollnum() {
        return rollnum;
    }

    public void setRollnum(int rollnum) {
        this.rollnum = rollnum;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollnum=" + rollnum +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentCity='" + studentCity + '\'' +
                '}';
    }


}
