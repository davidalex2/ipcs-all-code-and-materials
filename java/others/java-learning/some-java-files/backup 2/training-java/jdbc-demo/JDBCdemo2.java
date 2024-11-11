import java.sql.*;
public class JDBCdemo2 {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "insert into Student_Marks values(?,?,?,?,?,?,?)";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,7);
			pst.setString(2,"Jo");
			pst.setInt(3,42);
			pst.setInt(4,51);
			pst.setInt(5,61);
			pst.setInt(6,79);
			pst.setInt(7,76);
			int rows = pst.executeUpdate();
		}
		catch (Exception ex) {
			throw new RuntimeException("no result" +query,ex);
		}
	}
}
			//inert method