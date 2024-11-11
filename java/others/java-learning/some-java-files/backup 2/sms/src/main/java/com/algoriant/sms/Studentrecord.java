package com.algoriant.sms;
import com.algoriant.sms.dao.impl.StudentDaoImpl;
import com.algoriant.sms.dao.StudentDao;
import com.algoriant.sms.model.Student;
//import java.util.Date;
import java.util.List;

public class Studentrecord {
	
	public static void main(String[] args) {
		StudentDao studentDao1 = new StudentDaoImpl();
		for(Student student1:studentDao1.getAllStudent()) {
			System.out.println("Student : "+student1.getId()+" "+student1.getName()+" "+student1.getDept());
			
	}
		Student student1 = studentDao1.getAllStudent().get(0);
		student1.setName("Anbu");
		studentDao1.updateStudent(student1);
		studentDao1.getStudent(0);
		System.out.println("Student : "+student1.getId()+" "+student1.getName()+" "+student1.getDept());
	}
	
	
}