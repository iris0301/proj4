import java.sql.SQLException;

public class Client {
	public static void main(String[] args) throws SQLException{
		MySQLDriver dm = new MySQLDriver();
		//PostgreSQLDriver dm = new PostgreSQLDriver();
		//dm.generateData();
		dm.query1(455);
		dm.query2(100, 300);
		dm.query3("crsCode987242");
		dm.query4("name671686");
		dm.query5("deptId343480", "deptId573856");
		dm.query6("deptId821846");
	}
}
