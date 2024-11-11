import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
	
	public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/jdbc_db";
	String uname="postgres";
	String pwd="root";
	
	String query1="insert into students(id,name) values(?,?)";
				
		try{
			Connection conn1=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement prepare1=conn1.prepareStatement(query1);			
			prepare1.setInt(1,2);
			prepare1.setString(2,"alex");
			// prepare1.setString(3,"12345678");
			prepare1.executeUpdate();
		}
	catch(SQLException e) {
			e.printStackTrace();
		}
	}

}