package com.ipcs.example1.impl;

import com.ipcs.example1.model.Student;
import com.ipcs.example1.model.StudentDto;
import com.ipcs.example1.model.StudentResponce;

import java.util.List;
import java.util.Optional;

public interface StudentIMPL {
    public Student create(StudentDto studentDto);
    public Student update(int id,StudentDto studentDto);
    public StudentResponce get(int id);
    public void delete(int id);
    public List<Student> getall();

}
