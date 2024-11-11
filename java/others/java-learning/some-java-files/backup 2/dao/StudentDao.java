package com.algoriant.sms.dao;
import com.algoriant.sms.model.Student;
//import java.util.Date;
import java.util.List;

public interface StudentDao {
	public List<Student> getAllStudent();
	public Student getStudent(int id);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
	
}