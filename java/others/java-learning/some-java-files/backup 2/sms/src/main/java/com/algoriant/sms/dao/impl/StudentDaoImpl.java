package com.algoriant.sms.dao.impl;
import com.algoriant.sms.dao.StudentDao;
//import java.util.Date;
import com.algoriant.sms.model.Student;
import java.util.List;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
	 List< Student> listOfStudent;
	public StudentDaoImpl() {
		listOfStudent =new ArrayList<Student>();
		Student S1 = new Student(1,"Ram","EEE");
		Student S2 = new Student(2,"Arun","BA");
		listOfStudent.add(S1);
		listOfStudent.add(S2);

	}
	public List<Student>getAllStudent() {
		return listOfStudent;
	}
	public Student getStudent(int id) {
		return listOfStudent.get(id);
	}
	public void deleteStudent(Student student) {
		listOfStudent.remove(student.getId());
		System.out.println(""+student.getId());
	}
	public void updateStudent(Student student) {
		listOfStudent.get(student.getId()).setName(student.getName());
		System.out.println(" "+student.getId());
	
	}
	
}
	