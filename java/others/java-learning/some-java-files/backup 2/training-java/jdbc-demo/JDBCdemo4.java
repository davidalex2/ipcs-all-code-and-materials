import java.sql.*;
public class JDBCdemo4{
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "update Student_Marks set student_name = ? where id = ?";
		
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
			//update method