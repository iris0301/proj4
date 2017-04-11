import java.sql.*;

public class MySQLDriver extends Driver {
	// Driver name
	private final String driver = "com.mysql.jdbc.Driver";
	// Databasename :
	private final String url = "jdbc:mysql://127.0.0.1:3306/project4";
	// Mysql username
	private final String user = "root";
	// Mysql password
	private final String password = "root";
	
	public MySQLDriver() {
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