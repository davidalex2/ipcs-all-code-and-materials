import java.sql.*;
public class JDBCdemo3{
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "delete from Student_Marks where id = ?";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,3);
		
			int rows = pst.executeUpdate();
		}
		catch (Exception ex) {
			throw new RuntimeException("no result" +query,ex);
		}
	}
}
			//delete method