package com.algoriant.sms.model;

import javax.persistence.*;
import java.util.Date;

public class Student {
    int id,age;
    String name,dept;
    void Student(int id,String name,int age,String dept) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.dept=dept;

    }

    public void setId(int id) {
        this.id=id;
    }
    public int getId() {
        return  id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setDept(String dept) {
        this.dept=dept;
    }
    public String getDept(String cs) {
        return dept;
    }
    public void setDob(String dob) {
        this.dob=dob;
    }
    public String getDob() {
        return dob;
    }

}

class FirstProblem{
    public static void main(String[] args) {

    }
}