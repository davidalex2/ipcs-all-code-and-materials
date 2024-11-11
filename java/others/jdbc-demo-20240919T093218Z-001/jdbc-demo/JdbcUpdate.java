import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class JdbcUpdate {		
	public static void main(String[] args) {					
		try {
			String url="jdbc:postgresql://localhost:5432/jdbc_db";
			String uname="postgres";
			String pwd="root";
			String query="update students set id=?, name=? where name='alex'";		
			Scanner obj=new Scanner(System.in);
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement state=con.prepareStatement(query);
			state.setInt(1,1);
			state.setString(2,"raj");	
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}