import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	protected Connection conn;
	protected TupleGenerator generator = new TupleGeneratorImpl();
	protected int size[];
	protected Comparable[][][] data;

	protected void generateData() throws SQLException {
		generator.addRelSchema ("Student",
                "id name address status",
                "Integer String String String",
                "id",
                null);

		generator.addRelSchema ("Professor",
                "id name deptId",
                "Integer String String",
                "id",
                null);

		generator.addRelSchema ("Course",
                "crsCode deptId crsName descr",
                "String String String String",
                "crsCode",
                null);

		generator.addRelSchema ("Teaching",
                "crsCode semester profId",
                "String String Integer",
                "crcCode semester",
                new String [][] {{ "profId", "Professor", "id" },
                        { "crsCode", "Course", "crsCode" }});

		generator.addRelSchema ("Transcript",
                "studId crsCode semester grade",
                "Integer String String String",
                "studId crsCode semester",
                new String [][] {{ "studId", "Student", "id"},
                        { "crsCode", "Course", "crsCode" },
                        { "crsCode semester", "Teaching", "crsCode semester" }});
		size = new int[]{10000, 1000, 2000, 5000, 5000};
		//size = new int[]{100, 10, 20, 50, 50};
		data = generator.generate(size);
		generateStudent();
		generateProfessor();
		generateCourse();
		generateTeaching();
		generateTranscript();
	}

	protected void generateStudent() throws SQLException {
		String sql = "INSERT INTO Student(id, name, address, status) VALUES(?, ?, ?, ?)";
		PreparedStatement student = conn.prepareStatement(sql);
		Long time_start = System.currentTimeMillis();
		for (int i = 0; i < data[0].length; i++) {
			student.setInt(1, Integer.valueOf(String.valueOf(data[0][i][0])));
			student.setString(2, String.valueOf(data[0][i][1]));
			student.setString(3, String.valueOf(data[0][i][2]));
			student.setString(4, String.valueOf(data[0][i][3]));
			student.addBatch();
		}
		student.executeBatch();
		student.close();
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		System.out.println("Insert " + data[0].length + " data to Student takes " + time_taken + " msecs.");
	}
	
	protected void generateProfessor() throws SQLException {
		String sql = "INSERT INTO Professor(id, name, deptId) VALUES(?, ?, ?)";
		PreparedStatement professor = conn.prepareStatement(sql);
		Long time_start = System.currentTimeMillis();
		for (int i = 0; i < data[1].length; i++) {
			professor.setInt(1, Integer.valueOf(String.valueOf(data[1][i][0])));
			professor.setString(2, String.valueOf(data[1][i][1]));
			professor.setString(3, String.valueOf(data[1][i][2]));
			professor.addBatch();
		}
		professor.executeBatch();
		professor.close();
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		System.out.println("Insert " + data[1].length + " data to Professor takes " + time_taken + " msecs.");
	}
	
	protected void generateCourse() throws SQLException {
		String sql = "INSERT INTO Course(crsCode, deptId, crsName, descr) VALUES(?, ?, ?, ?)";
		PreparedStatement course = conn.prepareStatement(sql);
		Long time_start = System.currentTimeMillis();
		for (int i = 0; i < data[2].length; i++) {
			course.setString(1, String.valueOf(data[2][i][0]));
			course.setString(2, String.valueOf(data[2][i][1]));
			course.setString(3, String.valueOf(data[2][i][2]));
			course.setString(4, String.valueOf(data[2][i][3]));
			course.addBatch();
		}
		course.executeBatch();
		course.close();
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		System.out.println("Insert " + data[2].length + " data to Course takes " + time_taken + " msecs.");
	}
	
	protected void generateTeaching() throws SQLException {
		String sql = "INSERT INTO Teaching(crsCode, semester, profId) VALUES(?, ?, ?)";
		PreparedStatement teaching = conn.prepareStatement(sql);
		Long time_start = System.currentTimeMillis();
		for (int i = 0; i < data[3].length; i++) {
			teaching.setString(1, String.valueOf(data[3][i][0]));
			teaching.setString(2, String.valueOf(data[3][i][1]));
			teaching.setInt(3, Integer.valueOf(String.valueOf(data[3][i][2])));
			teaching.addBatch();
		}
		teaching.executeBatch();
		teaching.close();
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		System.out.println("Insert " + data[3].length + " data to Teaching takes " + time_taken + " msecs.");
	}
	
	protected void generateTranscript() throws SQLException {
		String sql = "INSERT INTO Transcript(studId, crsCode, semester, grade) VALUES(?, ?, ?, ?)";
		PreparedStatement transcript = conn.prepareStatement(sql);
		Long time_start = System.currentTimeMillis();
		for (int i = 0; i < data[4].length; i++) {
			transcript.setInt(1, Integer.valueOf(String.valueOf(data[4][i][0])));
			transcript.setString(2, String.valueOf(data[4][i][1]));
			transcript.setString(3, String.valueOf(data[4][i][2]));
			transcript.setString(4, String.valueOf(data[4][i][3]));
			transcript.addBatch();
		}
		transcript.executeBatch();
		transcript.close();
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		System.out.println("Insert " + data[4].length + " data to Transcript takes " + time_taken + " msecs.");
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
	 * List the name of the student with id equal to v1 (id)
	 * @throws SQLException 
	 */
	public void query1(int id) throws SQLException {
		System.out.println("Query1...");
		String sql = "SELECT name FROM Student WHERE id = "+ id;
		System.out.println(sql);
		Long time_start = System.currentTimeMillis();
		ResultSet rs = null;
		rs = getQueryResultSet(sql);
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		String name = null;

		System.out.println("Result...");
		while (rs.next()) {
			name = rs.getString(1);
			// Display
			System.out.println("Id: " + id + " Name: " + name);
		}
		System.out.println("Query1 takes " + time_taken + " msecs.\n");
		rs.close();
	}
	
	
	/**
	 * List the names of students with id in the range of v2 (id) to v3 (inclusive) 
	* @author Yunyun
	 * @throws SQLException 
	*/
	public void query2(int id1, int id2) throws SQLException {
		System.out.println("Query2...");
		String sql = String.format("SELECT name from Student WHERE id BETWEEN %d AND %d", id1, id2);
		System.out.println(sql);
		Long time_start = System.currentTimeMillis();
		ResultSet rs = null;
		rs = getQueryResultSet(sql);
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		String name = null;

		System.out.println("Result...");
		while (rs.next()) {
			name = rs.getString(1);
			// Display
			System.out.println("Name: " + name);
		}
		System.out.println("Query2 takes " + time_taken + " msecs.\n");
		rs.close();
	}
	
	/**
	 * 3.List the names of students who have taken course v4 (crsCode). 
	* @author Yunyun
	 * @throws SQLException 
	 */
	public void query3(String crsCode) throws SQLException {
		System.out.println("Query3...");
		String sql = String.format("SELECT name FROM Student INNER JOIN Transcript ON Student.Id = Transcript.StudId WHERE CrsCode = \"%s\"", crsCode);
		System.out.println(sql);
		Long time_start = System.currentTimeMillis();
		ResultSet rs = null;
		rs = getQueryResultSet(sql);
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		String name = null;

		System.out.println("Result...");
		while (rs.next()) {
			name = rs.getString(1);
			// Display
			System.out.println("Name: " + name);
		}
		System.out.println("Query3 takes " + time_taken + " msecs.\n");
		rs.close();
	}
	
	
	/**
	 * 
	* @author Yunyun
	 * @throws SQLException 
	* @Description: List the names of students who have taken a course taught by professor v5 (name).
	 */
	public void query4(String professorName) throws SQLException {
		System.out.println("Query4...");
		String sql = String.format("SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Teaching ON Transcript.CrsCode = Teaching.CrsCode INNER JOIN Professor ON Professor.Id = Teaching.ProfID WHERE Professor.Name = \"%s\"", professorName);
		System.out.println(sql);
		Long time_start = System.currentTimeMillis();
		ResultSet rs = null;
		rs = getQueryResultSet(sql);
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		String name = null;

		System.out.println("Result...");
		while (rs.next()) {
			name = rs.getString(1);
			// Display
			System.out.println("Name: " + name);
		}
		System.out.println("Query4 takes " + time_taken + " msecs.\n");
		rs.close();
	}
	
	/**
	 * @author Yunyun 
	 * List the names of students who have taken a course from department v6 (deptId), but not v7.
	 * @throws SQLException 
	 */
	public void query5(String deptId1 ,String deptId2) throws SQLException {
		System.out.println("Query5...");
		String sql = String.format("SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode WHERE deptId = \"%s\" AND deptID != \"%s\"", deptId1, deptId2);
		System.out.println(sql);
		Long time_start = System.currentTimeMillis();
		ResultSet rs = null;
		rs = getQueryResultSet(sql);
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		String name = null;

		System.out.println("Result...");
		while (rs.next()) {
			name = rs.getString(1);
			// Display
			System.out.println("Name: " + name);
		}
		System.out.println("Query5 takes " + time_taken + " msecs.\n");
		rs.close();
	}

	/*
	**
	 * @author Yunyun 
	 * List the names of students who have taken all courses offered by department v8 (deptId).
	 */
	public void query6(String deptId) throws SQLException {
		System.out.println("Query6...");
		String sql = String.format("SELECT Student.name FROM Student INNER JOIN Transcript ON Student.ID = Transcript.StudId INNER JOIN Course ON Transcript.CrsCode = Course.CrsCode WHERE deptId = \"%s\"", deptId);
		System.out.println(sql);
		Long time_start = System.currentTimeMillis();
		ResultSet rs = null;
		rs = getQueryResultSet(sql);
		Long time_end = System.currentTimeMillis();
		Long time_taken = time_end - time_start;
		String name = null;

		System.out.println("Result...");
		while (rs.next()) {
			name = rs.getString(1);
			// Display
			System.out.println("Name: " + name);
		}
		System.out.println("Query6 takes " + time_taken + " msecs.\n");
		rs.close();
	}
}
