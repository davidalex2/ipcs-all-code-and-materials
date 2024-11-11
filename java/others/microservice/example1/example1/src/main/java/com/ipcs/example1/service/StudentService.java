package com.ipcs.example1.service;

import com.ipcs.example1.impl.StudentIMPL;
import com.ipcs.example1.model.Student;
import com.ipcs.example1.model.StudentDto;
import com.ipcs.example1.model.StudentResponce;
import com.ipcs.example1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService implements StudentIMPL {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student create(StudentDto studentDto) {
        return studentRepo.save(Student.toEntity(studentDto));
    }

    @Override
    public Student update(int id, StudentDto studentDto) {
        Student student = new Student();
        Optional<Student> studentOptional = Optional.of(studentRepo.findById(id).get());
        if (studentOptional.isPresent()) {
            student.setId(id);
            student.setName(studentDto.getName());
            student.setMobile(studentDto.getMobile());
            student.setClass_n(studentDto.getClass_n());
            student.setEmail(studentDto.getEmail());
            studentRepo.save(student);
        }
        return student;
    }

    @Override
    public StudentResponce get(int id) {
        Optional<StudentResponce> optionalStudent = Optional.of(StudentResponce.toResponce(studentRepo.findById(id).get()));

        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getall() {
        List<Student> list = new ArrayList<>();
        studentRepo.findAll().forEach(list::add);
        return Student.toList(list);
    }
}
