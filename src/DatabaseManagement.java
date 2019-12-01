import static java.lang.System.out;

import java.sql.*;

public class DatabaseManagement {
	// Driver name
	private final String driver = "com.mysql.jdbc.Driver";
	// Databasename :
	private final String url = "jdbc:mysql://127.0.0.1:3306/proj4test";
	// Mysql username
	private final String user = "root";
	// Mysql password
	private final String password = "Potato.com99";
	private Connection conn;

	/**
	 * @author Yunyun
	 */
	public void initDatabase() {

		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			if (!conn.isClosed()) {
				System.out.println("\nConnected database successfully...\n");
			} else {
				System.out.println("Failed connecting to the Database!\n");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @author Yunyun
	 */
	public void closeDatabase() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author Yunyun
	 */
	public ResultSet getQueryResultSet(String sql) {
		Statement statement;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * @author Yunyun
	 */
	public void testDatabaseManagement() {
		initDatabase();
		String sql = "select * from departments";
		ResultSet rs = getQueryResultSet(sql);

		try {
			while (rs.next()) {
				System.out.println(rs.getString("dept_no") + "\t" + rs.getString("dept_name"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @author Yunyun 
	 * List the name of the student with id equal to v1 (id)
	 */
	public void query1(int id) {
		initDatabase();
		String sql = "Select * from student where id ="+ id;
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = getQueryResultSet(sql);
			String name = null;

			while (rs.next()) {
				name = rs.getString(2);
				// 2.Display
				System.out.println("Id:" + id + "   Name:" + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	/**
	 * List the names of students with id in the range of v2 (id) to v3 (inclusive) 
	* @author Yunyun
	*/
	public void query2(int id1,int id2) {
		initDatabase();
		String sql = "Select * from student where id between " +id1 + " and "+ id2;
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = getQueryResultSet(sql);
			String name = null;

			while (rs.next()) {
				name = rs.getString(2);
				// 2.Display
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * 3.List the names of students who have taken course v4 (crsCode). 
	* @author Yunyun
	 */
	public void query3(String crsCode) {
		initDatabase();
		String sql = "Select s.name from student s, Transcript t, Course c where s.id = t.studId AND t.crsCode = c.crsCode AND c.crsCode ='" +  crsCode +"'";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = getQueryResultSet(sql);
			String name = null;

			while (rs.next()) {
				name = rs.getString(1);
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	/**
	 * 
	* @author Yunyun
	* @Description: List the names of students who have taken a course taught by professor v5 (name).
	 */
	public void query4(String professorName ) {
		initDatabase();
		String sql = "Select s.name from student s, Transcript transcript,Teaching  teaching, Professor p where s.id = transcript.studId AND teaching.crsCode = transcript.crsCode AND teaching.profId = p.id  AND p.name =   '" +  professorName +"'";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = getQueryResultSet(sql);
			String name = null;

			while (rs.next()) {
				name = rs.getString(1);
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * @author Yunyun 
	 * List the names of students who have taken a course from department v6 (deptId), but not v7.
	 */
	public void query5(int deptId1 ,int deptId2) {
		initDatabase();
		String sql = "Select s.name from student s, course c ,Transcript transcript where transcript.studId = s.id AND transcript.crsCode = c.crsCode AND  c.deptId = "+ deptId1 +" AND c.deptId !="+ deptId2+"";
		ResultSet rs = null;
		try {
			rs = getQueryResultSet(sql);
			String name = null;
			System.out.println(sql);

			while (rs.next()) {
				name = rs.getString(1);
				// 2.Display
				System.out.println(name);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/*
	**
	 * @author Yunyun 
	 * List the names of students who have taken all courses offered by department v8 (deptId).
	 */
	public void query6(int deptId) {
		initDatabase();
		String sql = "Select s.name from student s, course c ,Transcript t where s.id = t.studId AND t.crsCode = c.crsCode AND  c.deptId = " + deptId;
		ResultSet rs = null;
		try {
			rs = getQueryResultSet(sql);
			String name = null;
			System.out.println(sql);

			while (rs.next()) {
				name = rs.getString(1);
				// 2.Display
				System.out.println(name);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	
	
	/**
	 * @author Fu
	 * @return
	 */
	public boolean tupleGeneratorArpinar(){
		initDatabase();
		System.out.println("Inserting records into the table...");

		TupleGeneratorImpl test = new TupleGeneratorImpl ();

        test.addRelSchema ("Student","id name address status","Integer String String String","id",null);
        test.addRelSchema ("Professor","id name deptId","Integer String String","id",null);
        test.addRelSchema ("Course","crsCode deptId crsName descr","String String String String","crsCode",null);
        test.addRelSchema ("Teaching","crsCode semester profId","String String Integer","crcCode semester",new String [][] {{ "profId", "Professor", "id" },{ "crsCode", "Course", "crsCode" }});
        test.addRelSchema ("Transcript","studId crsCode semester grade","Integer String String String","studId crsCode semester",new String [][] {{ "studId", "Student", "id"},{ "crsCode", "Course", "crsCode" },{ "crsCode semester", "Teaching", "crsCode semester" }});

        String [] tables = { "Student", "Professor", "Course", "Teaching", "Transcript" };
        
        int tups [] = new int [] { 10000, 1000, 2000, 5000, 5000 };
    
        Comparable [][][] resultTest = test.generate (tups);
        
        Statement statement = null;
        
        String query = null;
        
        try {
			statement = conn.createStatement();
			
			for (int i = 0; i < resultTest.length; i++) {
	            out.println (tables [i]);
	            for (int j = 0; j < resultTest [i].length; j++) {
	            	query = null;
	            	if(i == 0) query = "INSERT INTO Student (id, name, address,status) VALUES (";
	            	else if(i == 1) query = "INSERT INTO Professor (id, name, deptId) VALUES (";
	            	else if(i == 2) query = "INSERT INTO Course (crsCode, deptId, crsName, descry) VALUES (";
	            	else if(i == 3) query = "INSERT INTO Teaching (crsCode, semester, profId) VALUES (";
	            	else if(i == 4) query = "INSERT INTO Transcript (studId, crsCode, semester, grade) VALUES (";
	            	//else if(i == 3) query = "INSERT INTO Transcript (studId, crsCode, semester, grade) VALUES (";
	            	//else if(i == 4) query = "INSERT INTO Teaching (profId, crsCode, semester) VALUES (";
	            	
	                for (int k = 0; k < resultTest [i][j].length; k++) {
	                    //out.print (resultTest [i][j][k] + ",");
	                    query += "'" + resultTest[i][j][k] + "'";
	                    if(k != resultTest[i][j].length-1) query += ",";
	                    if(k == resultTest[i][j].length-1) query += ")";
	                    out.print("QUERY: " + query);
	                } // for
	                out.println ();
	                statement.executeUpdate(query);

	            } // for
	            out.println ();
	        } // for
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nFailed to execute query!\n");
			return false;
		} finally{
			closeDatabase();
		}
        
		System.out.println("Inserted records into the table...");
		return true;
	}

}