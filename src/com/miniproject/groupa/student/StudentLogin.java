package com.miniproject.groupa.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.miniproject.groupa.util.DBUTILConnection;

public class StudentLogin 
{	
	String userName ;
	String userPassword;
	int studentId;
	
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	public void getLogin() throws SQLException
	{

		PreparedStatement ps = null;

		Connection con = DBUTILConnection.getConnection();

		    System.out.println("Enter the username >>>");
	    	Scanner sc = new Scanner(System.in);
	    	String username = sc.nextLine();
	    	System.out.println("Enter the password >>>");
	    	String password = sc.nextLine();	
		
		ps = con.prepareStatement("select student_id from student where user_name =? AND password = ?");

		ps.setString(1, username);
		ps.setString(2, password);

		ResultSet loginResult = ps.executeQuery();

		if (loginResult.next()) {
			
			System.out.println("Login successfull...........");
			 userName = username;
			 userPassword =password;
			 studentId = loginResult.getInt("student_id");
		} else {
			System.out.println("Invalid username or password");
		}
		DBUTILConnection.closeConnection();		
	}
}