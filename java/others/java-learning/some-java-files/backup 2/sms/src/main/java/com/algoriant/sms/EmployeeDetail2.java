package com.algoriant.sms;
import com.algoriant.sms.dao.impl.EmployeeDaoImpl1;
import com.algoriant.sms.dao.EmployeeDao1;
import com.algoriant.sms.model.Employee;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class EmployeeDetail2 {
	
	public static void main (String[] args) {
		
		Employee employee = new Employee();
		EmployeeDao1 employeeDao1 = new EmployeeDaoImpl1();
		//employeeDao1.getAllEmployee( );
		employeeDao1.updateEmployee(employee);
		
	}
	
}

