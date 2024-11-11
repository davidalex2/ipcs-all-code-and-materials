package com.algoriant.sms;
import com.algoriant.sms.dao.impl.EmployeeDaoImpl;
import com.algoriant.sms.dao.EmployeeDao;
import com.algoriant.sms.model.Employee;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class EmployeeDetail {
	
	public static void main (String[] args) {
		Employee employee = new Employee();
		employee.setEmpid(1);
		employee.setEmpname("Arun");
		employee.setEmpsalary(2000);
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.insertEmployee(employee);
	}
	
}

