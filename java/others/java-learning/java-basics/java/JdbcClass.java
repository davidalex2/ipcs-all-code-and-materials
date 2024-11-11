class JdbcClass {
	public static void main(String[] args) {
		Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432","postgres","postgres");
	}
}