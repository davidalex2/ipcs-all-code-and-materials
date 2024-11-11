import java.sql.*;
public class JDBCdemo7 {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String select_all_query = "select * from Student_Marks";
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(select_all_query);
			ResultSet rs = pst.executeQuery();
	
			while(rs.next()) {
				int id = rs.getInt("id");
				String studentName = rs.getString("student_name");
				int tamilMark = rs.getInt("tamil_mark");
				int englishMark = rs.getInt("english_mark");
				int mathsMark = rs.getInt("maths_mark");
				int scienceMark = rs.getInt("science_mark");
				int socialMark = rs.getInt("social_mark");
				System.out.println(id+","+studentName+" "+tamilMark+" "+englishMark+" "+mathsMark+" "+scienceMark+" "+socialMark);
			}
		} 
		catch(Exception ex){
			throw new RuntimeException("no result: "+ select_all_query, ex);
		}
	}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		