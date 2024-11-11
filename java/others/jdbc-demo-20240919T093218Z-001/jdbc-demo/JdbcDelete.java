import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDelete {
	public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/jdbc_db";
	String uname="postgres";
	String pwd="root";
	String query="delete from students where name=?";	
	try {
		Connection con=DriverManager.getConnection(url,uname,pwd);
		PreparedStatement state=con.prepareStatement(query);	
		state.setString(1,"raj");
		state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}