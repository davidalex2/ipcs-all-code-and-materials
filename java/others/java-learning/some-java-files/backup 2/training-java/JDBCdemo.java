import java.sql.*;
public class JDBCdemo {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresjdbc://localhost:5432/test";
		String username  = "postgres";
		String password = "postgres";
		String query = "select * from Student_Marks";
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			while(rs.next()) {
				int id = rs.getInt("id");
				String student_name = rs.getString("student_name");
				int tamil_mark = rs.getInt("tamil_mark");
				int english_mark = rs.getInt("english_mark");
				int maths_mark = rs.getInt("maths_mark");
				int science_mark = rs.getInt("science_mark");
				int social_mark = rs.getInt("social_mark");
				System.out.println(""+id,""+student_mark,""+tamil_mark,""+english_mark,""+maths_mark,""+science_mark,""+social_mark);
			}
		} catch(SQLException e){
		
		}
			
		
		
	}
}