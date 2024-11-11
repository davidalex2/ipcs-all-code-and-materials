package com.algoriant.sms.dao.impl;
import com.algoriant.sms.dao.EmployeeDao;
import com.algoriant.sms.model.Employee;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class EmployeeDaoImpl implements EmployeeDao{
	List< Employee> noOfEmployee;
	 public void insertEmployee(Employee employee) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "insert into Employee values(?,?,?)";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,employee.getEmpid());
			pst.setString(2,employee.getEmpname());
			pst.setInt(3,employee.getEmpsalary());
			int rows = pst.executeUpdate();
		}
		catch (Exception ex) {
			throw new RuntimeException("no result" +query,ex);
		}
	
	}
	
	
	//public List<Employee>getAllEmployee() {
		//return noOfEmployee;
	//}
	//public Employee getEmployee(int empid) {
		//return noOfEmployee.get(empid);
	//}
	//public void deleteEmployee(Employee employee) {
		//noOfEmployee.remove(employee.getEmpid());
		//System.out.println(""+employee.getEmpid());
	//}
	//public void updateEmployee(Employee employee) {
		//noOfEmployee.get(employee.getEmpid()).setEmpname(employee.getEmpname());
		//System.out.println(" "+employee.getEmpid());
	
	//}
	
	
}
		