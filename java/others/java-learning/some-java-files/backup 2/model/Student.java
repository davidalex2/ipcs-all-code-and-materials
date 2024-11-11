package com.algoriant.sms.model;
//import java.util.Date;
public class Student {

	private int id;
	private String name;
	private String dept;
	//private Date dob;
	
	public Student(int id,String name,String dept){//Date dob) {
		this.id = id;
		this.name = name; 
		this.dept = dept;
		//this.dob = dob;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	//public Date getDob(){
		//return dob;
	//}
	//public void setDob(Date dob) {
	//	this.dob = dob;
	//}
}
		
	
