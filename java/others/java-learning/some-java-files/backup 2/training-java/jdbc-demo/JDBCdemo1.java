import java.sql.*;
public class JDBCdemo1 {

	public static void main(String[] args) throws SQLException {
		insertStudentRecord() ;
		
	}
	
	private static void getStudentRecord() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "select * from Student_Marks";
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
		
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
		} catch(Exception ex){
			throw new RuntimeException("Failure to get the student result: "+query, ex);
		}
	}
	private static void insertStudentRecord() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username  = "postgres";
		String password = "postgres";
		String query = "insert into Student_Marks values(6,'Anbu',60,63,77,88,99)";
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			int rows = st.executeUpdate(query);
		}
		catch (Exception ex) {
			throw new RuntimeException("no result" +query,ex);
		}
	}
		
	
}