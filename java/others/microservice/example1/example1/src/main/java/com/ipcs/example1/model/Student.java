package com.ipcs.example1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String class_n;
    private String email;
    private long mobile;

    public static Student toEntity(StudentDto studentDto){
        Student student=new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setMobile(studentDto.getMobile());
        student.setClass_n(studentDto.getClass_n());
        return student;
    }

    public static List<Student> toList(List<Student> list) {
        Student student=new Student();
        student.getName();
        student.getEmail();
        student.getId();
        student.getClass_n();
        student.getMobile();
//        List<Student> slist=new ArrayList<>();
        list.add(student);
        return list;
    }
}
