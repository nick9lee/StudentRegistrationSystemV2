package registration;
import java.beans.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.sql.*;
import com.sun.jdi.connect.spi.Connection;

/**
 * this class is responsible for reading in and managing info from the database
 * @author Nicho
 *
 */
public class DBManager implements IDBCredentials {
	private java.sql.Connection con;
	private java.sql.Connection con2;
	private java.sql.Statement stmt;
	ArrayList <Course> courseList;
	ArrayList<Student> studentList;

	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}

	/**
	 * responsible for connecting machine to database
	 */
	public void initializeConnection() {
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			con2 = DriverManager.getConnection(URL_COURSES,USERNAME,PASSWORD);
		}catch(SQLException e) {
			System.out.println("the thingy with workbench didnt work");
		}	
	}
	
	/**
	 * reads students in from data base and creates them
	 * @throws SQLException
	 */
	public void readStudent() throws SQLException{
		java.sql.Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("select * from student");
		int id = 0;
		String name = "";
		while(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			
			studentList.add(new Student(name, id));
        }
	}
	
	/**
	 * reads course info from data base and creates courses
	 * @throws SQLException
	 */
	public void readCourse() throws SQLException{
		java.sql.Statement statement = con2.createStatement();
		ResultSet rs = statement.executeQuery("select * from table1");
		int id = 0;
		String name = "";
		int numberofsections = 0;
		int pplcap = 0;
		int numberofcourses = 0;
		
		while(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			numberofsections = rs.getInt(3);
			pplcap = rs.getInt(4);
			
			courseList.add(new Course(name, id));
			
			
			for(int i = 1; i<= numberofsections; i++) {
				courseList.get(numberofcourses).addOffering(new CourseOffering(i, pplcap));
			}
			numberofcourses++;
		}
	}
	
	/**
	 * adds students from database into random courses
	 */
	public void enrollStudents() {
		
		for(Student stu : studentList) {
			Random random = new Random();
			int section = random.nextInt(3)+1;
			
			for(Course course: courseList) {
				course.getCourseOfferingAt(section).addStudent(stu);
			}
		}
	}
	
	/**
	 * responsible for calling functions that read info from the database.
	 * @return
	 */
	public ArrayList<Course> readFromDataBase() {        
		
		
		initializeConnection();
		try {
			readStudent();
			readCourse();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enrollStudents();

		return courseList;
	}

}
