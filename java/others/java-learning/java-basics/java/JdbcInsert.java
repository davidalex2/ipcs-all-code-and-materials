import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
	
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/postgres";
		String uname="postgres";
		String pwd="root";
		String query="insert into JD(id,name,pwd) values(?,?,?)";	
		try {
			Connection con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement ps=con.prepareStatement(query1);			
			ps.setInt(1,1);
			ps.setString(2,"david");
			ps.setString(3,"12345678");
			int abc=ps.executeUpdate();
			if (abc==true) {
				System.out.println("Entered sucessfully");
			} else {
				System.out.println("Not entered");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}