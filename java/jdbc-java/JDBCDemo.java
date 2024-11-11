import java.sql.*;

public class JDBCDemo {
  
    public static void main(String args[])
        throws SQLException, ClassNotFoundException
    {
        String driverClassName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/jdbc_db";
        String username = "postgres";
        String password = "root";
        String query = "insert into students values(109, 'bhatt')";

        Class.forName(driverClassName);

        // Obtain a connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Obtain a statement
        Statement st = con.createStatement();

        // Execute the query
        int count = st.executeUpdate(query);
        System.out.println("number of rows affected by this query= " + count);

        // Closing the connection as per the requirement with connection is completed
        con.close();
    }
}