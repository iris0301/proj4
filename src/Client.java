import java.sql.SQLException;

public class Client {
	public static void main(String[] args) throws SQLException{
		//MySQLDriver dm = new MySQLDriver();
				DatabaseManagement dm = new DatabaseManagement();
				//PostgreSQLDriver dm = new PostgreSQLDriver();
				/*try {
					dm.generateData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				dm.tupleGeneratorArpinar();
		
		
				
				/**
				 * @author Yunyun
				 */
		MySQLDriver dm2 = new MySQLDriver();
		//PostgreSQLDriver dm = new PostgreSQLDriver();
		//dm.generateData();
		dm2.query1(455);
		dm2.query2(100, 300);
		dm2.query3("crsCode987242");
		dm2.query4("name671686");
		dm2.query5("deptId343480", "deptId573856");
		dm2.query6("deptId821846");
	}
}
