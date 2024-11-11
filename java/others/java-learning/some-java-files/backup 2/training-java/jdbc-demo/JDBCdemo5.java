import java.sql.*;
public class JDBCdemo5 {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "postgres";
		String query = "select * from Student_Marks where student_name = ?";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,"Varun");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println(" "+rs.getInt("id")+" "+rs.getString("student_name")+" "+rs.getInt("tamil_mark")+" "+rs.getInt("english_mark")+" "+rs.getInt("maths_mark")+" "+rs.getInt("science_mark")+" "+rs.getInt("social_mark"));
				
			}
		}
		catch (Exception ex) {
			throw new RuntimeException("no result" +query,ex);
		}
	}
}
