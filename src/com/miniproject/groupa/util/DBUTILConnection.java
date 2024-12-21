package com.miniproject.groupa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTILConnection {

	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String Driver_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String Driver_Username = "system";
	private static final String Driver_Password = "system";

	static Connection con = null;
	
	// Design method which return connection object to that method
	public static Connection getConnection() {
		// Step-1. Loading driver class
		
		try {
			Class.forName(Driver_Name);
			// Step-2. Establish connection
			con = DriverManager.getConnection(Driver_URL, Driver_Username, Driver_Password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
