import java.sql.*;

public class PostgreSQLDriver extends Driver {
	// Driver name
	private final String driver = "org.postgresql.Driver";
	// Databasename :
	private final String url = "jdbc:postgresql://localhost/project4";
	// Mysql username
	private final String user = "postgres";
	// Mysql password
	private final String password = "postgres";
	
	public PostgreSQLDriver() {
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			if (!conn.isClosed()) {
				System.out.println("Connected database successfully...\n");
			} else {
				System.out.println("Failed connecting to the Database!\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void finalize() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}