package com.algoriant.sms.model;
public class Employee {

	private int empid;
	private String empname;
	private int empsalary;
	
	public Employee() {}
	
	public Employee(int empid,String empname,int empsalary) {
		this.empid = empid;
		this.empname = empname; 
		this.empsalary = empsalary;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(int empsalary) {
		this.empsalary = empsalary;
	}
	
}
		
	
