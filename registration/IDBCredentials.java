package registration;

/**
 * provides the data base manager with the info required to read from the database
 * @author Nicho
 *
 */
public interface IDBCredentials {

	// JDBC driver name and database URL
	
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/studentdatabase";
	   static final String URL_COURSES = "jdbc:mysql://localhost:3306/coursedatabase";

	   //  Database credentials
	   static final String USERNAME = "root";
	   static final String PASSWORD = "499040001";

}
