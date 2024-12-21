package com.miniproject.groupa.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.miniproject.groupa.util.DBUTILConnection;

public class QuestionService {
	
	public List<Questions> getQuestionData() throws SQLException {
		List<Questions> questionsList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;

		ResultSet rs = null;

		try {
			con = DBUTILConnection.getConnection();

			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from questions");

			while (rs.next()) {
				
				Questions questions = new Questions();

				questions.setQuestionId(rs.getInt(1));
				questions.setQuestionText(rs.getString(2));
				questions.setOption_1(rs.getString(3));
				questions.setOption_2(rs.getString(4));
				questions.setOption_3(rs.getString(5));
				questions.setOption_4(rs.getString(6));
				questions.setCorrectChoice(rs.getString(7));

				questionsList.add(questions);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			rs.close();
			stmt.close();
			con.close();
		}

		return questionsList;
	}

	
	public int getChoice(List<Questions> questionData) 
	{
		Scanner sc = null;
		int score = 0;
		try {

			sc = new Scanner(System.in);

			for (Questions question : questionData) {
				
				System.out.println("Question id = " + question.getQuestionId());
				System.out.println("Question = " + question.getQuestionText());
				System.out.println("Option1= " + question.getOption_1());
				System.out.println("Option2 = " + question.getOption_2());
				System.out.println("Option3 = " + question.getOption_3());
				System.out.println("Option4 = " + question.getOption_4());

				System.out.println("Enter your choice >>");
				String answer_choice = sc.nextLine();

				/// compare current choice with correct answer choice
				if (answer_choice.equalsIgnoreCase(question.getCorrectChoice())) {
					score++;
				}
			}

			System.out.println("Final score is >>> " + score);

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return score;
	}

	// To insert final score into database
	public void saveFinalScore(int studentId, int finalScore) throws SQLException {
		String grade = calculateGrade(finalScore);
		Connection con = null;
		PreparedStatement ps = null;

		con = DBUTILConnection.getConnection();

		ps = con.prepareStatement("insert into result(result_id,grade,score,student_id) values(?,?,?,?)");

		ps.setInt(1, studentId);
		ps.setString(2, grade);
		ps.setInt(3, finalScore);
		ps.setInt(4, studentId);

		ps.executeUpdate();

		System.out.println("Score inserted into database.");
	}

	
	private String calculateGrade(int finalScore) {
		
		if (finalScore >= 9) {
			return "Distinction";
		} else if (finalScore >= 7) {
			return "FirstClass";
		} else if (finalScore >= 5) {
			return "SecondClass";
		} else {
			return "Failed";
		}
	}

}
