package com.ipcs.example1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponce {
    private int id;
    private String name;
    private String class_n;
    private String email;
    private long mobile;

    public static StudentResponce toResponce(Student student){
        StudentResponce studentResponce=new StudentResponce();
        studentResponce.setId(student.getId());
        studentResponce.setName(student.getName());
        studentResponce.setMobile(student.getMobile());
        studentResponce.setEmail(student.getEmail());
        studentResponce.setClass_n(student.getClass_n());
        return studentResponce;
    }

}
