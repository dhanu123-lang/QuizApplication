package com.miniproject.groupa.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.miniproject.groupa.util.DBUTILConnection;

public class StudentResult {

	public void displayQuizResult(String userName, String userPassword) throws SQLException {

		PreparedStatement ps = null;

		Connection con = DBUTILConnection.getConnection();

		ps = con.prepareStatement("select student_id from student where user_name =? AND password = ?");

		System.out.println("Enter the username >>>");
    	Scanner sc = new Scanner(System.in);
    	String username = sc.nextLine();
    	System.out.println("Enter the password >>>");
    	String password = sc.nextLine();	
		
		ps.setString(1, username);
		ps.setString(2, password);

		ResultSet loginResult = ps.executeQuery();

		if (loginResult.next()) {
			int studentId = loginResult.getInt("student_id");

			ps = con.prepareStatement("select score,grade from result where student_id=?");

			ps.setInt(1, studentId);

			ResultSet result = ps.executeQuery();

			if (result.next()) {

				int studentScore = result.getInt("score");
				String studentGrade = result.getString("grade");

				System.out.println("Your score is >>> " + studentScore);
				System.out.println("Your grade is >>> " + studentGrade);
			}
		} else {
			System.out.println("Invalid username or password");
		}
		DBUTILConnection.closeConnection();
	}
}
