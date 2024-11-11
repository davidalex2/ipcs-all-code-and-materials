import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleJdbc {
	private String url="";
	private String name="";
	private String pwd="";
	
	private static String query1="Insert into table1(name,pwd) valuse(?,?,)";
	
	public static void main(String[] args) {
		
	}
	public void inserM() {
		try(Connection conn=DriverManager.getConnection(url,name,pwd);PreparedStatement pre=conn.preparedStatement(System.err)) {
			pre.setString(1,"David");
			pre.setString(2,"alex123");
		}
	}
}