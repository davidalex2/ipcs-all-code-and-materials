package com.ipcs.example1.controller;

import com.ipcs.example1.model.Student;
import com.ipcs.example1.model.StudentDto;
import com.ipcs.example1.model.StudentResponce;
import com.ipcs.example1.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping( "/add")
    public ResponseEntity<Student> create(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.create(studentDto), HttpStatus.CREATED);
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<Student> update(@PathVariable("id")int id, @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.update(id,studentDto),HttpStatus.OK);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        studentService.delete(id);
        return new ResponseEntity<>("user removed",HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponce> get(@PathVariable("id")int id){
        return new ResponseEntity<>(studentService.get(id),HttpStatus.OK);

    }
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getall(){
        return new ResponseEntity<>(studentService.getall(),HttpStatus.OK);
    }
}

