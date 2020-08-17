package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/run_training";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "China12!";
	private static Connection connection;
	private static DbConnection instance;
	
	private DbConnection(Connection connection) {
		DbConnection.connection = connection;
	}
	
	public static Connection getConnection() {
		//if ( instance == null ) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DbConnection(connection);
				//System.out.println("Connection successful.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		//}
		return DbConnection.connection;
	}
}
