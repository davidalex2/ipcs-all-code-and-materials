package com.algoriant.sms.dao.impl;
import com.algoriant.sms.dao.EmployeeDao1;
import com.algoriant.sms.model.Employee;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class EmployeeDaoImpl1 implements EmployeeDao1 {
	List< Employee>list = new ArrayList<Employee>();
	//public List<Employee> getAllEmployee(){
		//String url = "jdbc:postgresql://localhost:5432/postgres";
		//String username  = "postgres";
		//String password = "postgres";
		//String select_all_query = "select * from Employee";
		//try {
			//Connection con = DriverManager.getConnection(url,username,password);
			//PreparedStatement pst = con.prepareStatement(select_all_query);
			//ResultSet rs = pst.executeQuery();
			//while(rs.next()) {
				//int empid = rs.getInt("empid");
				//String empname = rs.getString("empname");
				//int empsalary = rs.getInt("empsalary");
				//System.out.println(""+empid+""+empname+""+empsalary);
			//}

		//}
		 //catch(Exception ex){
			//throw new RuntimeException("no result: "+ select_all_query, ex);
		//}
		//return null;
		
	//}
//}



	public void updateEmployee(Employee employee) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "update Employee set empname = ? where empid = ?";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,"Sara");
			pst.setInt(2,1);
			int rows = pst.executeUpdate();
		}
		catch (Exception ex) {
			throw new RuntimeException("no result" +query,ex);
		}
		
	}
}


