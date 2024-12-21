package com.miniproject.groupa.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.miniproject.groupa.util.DBUTILConnection;

public class AdminService {

	Connection con;
	Statement stmt;

	ResultSet rs;
	
	Scanner scanner;
	PreparedStatement preparedStatement;

	private void insertQuestionToDB(int id, String question_text, String opt1, String opt2, String opt3, String opt4,
			String correct_choice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBUTILConnection.getConnection();

			// Admin --- to add questions into database
			ps = con.prepareStatement(
					"insert into questions(question_id,question_text,option_1,option_2,option_3,option_4,correct_choice) values(?,?,?,?,?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, question_text);
			ps.setString(3, opt1);
			ps.setString(4, opt2);
			ps.setString(5, opt3);
			ps.setString(6, opt4);
			ps.setString(7, correct_choice);
			ps.executeUpdate();

			System.out.println("data inserted ............");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
			DBUTILConnection.closeConnection();
		}
	}

	private void getQuestionInfo() throws SQLException {
		// id,text,opt1,opt2,opt3,opt4,correct
		System.out.println("Enter id>>");
		scanner = new Scanner(System.in);
		int quesId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter question text >>");
		String quesText = scanner.nextLine();
		System.out.println("Enter opt1>>");
		String quesOpt1 = scanner.nextLine();
		System.out.println("Enter opt2>>");
		String quesOpt2 = scanner.nextLine();
		System.out.println("Enter opt3>>");
		String quesOpt3 = scanner.nextLine();
		System.out.println("Enter opt4>>");
		String quesOpt4 = scanner.nextLine();
		System.out.println("Enter correct choice>>");
		String quesCorrect = scanner.nextLine();

		insertQuestionToDB(quesId, quesText, quesOpt1, quesOpt2, quesOpt3, quesOpt4, quesCorrect);
	}

	public void addQuestions() throws SQLException {

		System.out.println("Enter 10 questions data >>>");

		for (int i = 1; i <= 10; i++) {
			getQuestionInfo();
		}
	}

	public void displayAllScore() throws SQLException {

		try {
			con = DBUTILConnection.getConnection();

			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select student.first_name,student.last_name, result.score,result.grade from student join result "
							+ "on student.student_id = result.result_id ORDER BY result.score ASC");

			while (rs.next()) {

				String studentFirstName = rs.getString("first_name");
				String studentLastName = rs.getString("last_name");
				int studentScore = rs.getInt("score");
				String studentGrade = rs.getString("grade");

				System.out.println("First name >> "+studentFirstName);
				System.out.println("Last name >> "+studentLastName);
				System.out.println("Score >>"+studentScore);
				System.out.println("Grade  >>" +studentGrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			DBUTILConnection.closeConnection();
		}
	}
	
	public void fetchScoreById() throws SQLException
	{
		
		System.out.println("Enter student id >>");
		
		try {
			scanner = new Scanner(System.in);
			int studentId = scanner.nextInt();
			
			con = DBUTILConnection.getConnection();

			// Admin --- to add questions into database
			preparedStatement = con.prepareStatement("select score,grade from result where student_id = ?");

			preparedStatement.setInt(1, studentId);
			
			ResultSet resultData = preparedStatement.executeQuery();
			
			if(resultData.next())
			{
				int studentScore = resultData.getInt("score");
				String studentGrade = resultData.getString("grade");

				System.out.println("Student Id >> "+studentId);
				System.out.println("Score is >> "+studentScore);
				System.out.println("Grade is >> "+studentGrade);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//scanner.close();
			preparedStatement.close();
			DBUTILConnection.closeConnection();
		}
	}
	
	public boolean adminLogin() throws SQLException
	{
       boolean validLogin = false;
       
		System.out.println("Enter admin username >>");
		Scanner sc = new Scanner(System.in);
		String adminUserName = sc.nextLine();
		System.out.println("Enter admin password >>");
		String adminPassword = sc.nextLine();
		
		PreparedStatement ps = null;

		Connection con = DBUTILConnection.getConnection();

		ps = con.prepareStatement("select admin_id from admin where admin_user_name =? AND admin_password = ?");

		ps.setString(1, adminUserName);
		ps.setString(2, adminPassword);

		ResultSet adminLoginResult = ps.executeQuery();

		if (adminLoginResult.next()) {
			System.out.println("Admin login successfull !");
			validLogin = true;
		} else {
			System.out.println("Invalid admin username or password");
			validLogin = false;
		}
		DBUTILConnection.closeConnection();
		return validLogin;
	}
}
