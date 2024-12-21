package com.miniproject.groupa;

import java.util.List;
import java.util.Scanner;
import com.miniproject.groupa.admin.AdminService;
import com.miniproject.groupa.question.QuestionService;
import com.miniproject.groupa.question.Questions;
import com.miniproject.groupa.student.StudentLogin;
import com.miniproject.groupa.student.StudentRegistration;
import com.miniproject.groupa.student.StudentResult;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		StudentLogin studentLogin = new StudentLogin();

		StudentResult studentResult = new StudentResult();

		AdminService adminService = new AdminService();

		boolean validAdminLogin = false;

		System.out.println("Welcome to console based application  \n " + "Student Operation \n"
				+ " 1. Student Registration \n " + " 2. Student Login \n " + " 3. Display the list of questions \n "
				+ " 4. Store Quiz result into database \n " + " 5. Display Quiz result  \n " + "Admin Operations \n"
				+ " 6. Display all students score as per ascending order \n " + "7. Fetch student score by using id \n"
				+ " 8. Add question with 4 options into database\r\n" + "9. Admin Login \n " + "10. Exit \n");

		try {

			while (true) {

				System.out.print("Enter your choice >>  ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					StudentRegistration.registerStudent();
					break;
				}

				case 2: {
					studentLogin.getLogin();
					break;
				}

				case 3: {
					if (studentLogin.getStudentId() == 0) {
						System.out.println("Please login and try again!");
						break;
					}

					System.out.println("Display the questions >>>");
					QuestionService displayQuestions = new QuestionService();
					List<Questions> questionData = displayQuestions.getQuestionData();
					int finalScore = displayQuestions.getChoice(questionData);
					displayQuestions.saveFinalScore(studentLogin.getStudentId(), finalScore);
					break;
				}

				case 4: {
					System.out.println("Store result into database as part of case 3");
					break;
				}

				case 5: {
					studentResult.displayQuizResult(studentLogin.getUserName(), studentLogin.getUserPassword());
					break;
				}

				case 6: {
					if (validAdminLogin == false) {
						System.out.println("This is admin feature. Please login with admin user & try again!");
						break;
					}
					adminService.displayAllScore();
					break;
				}

				case 7: {
					if (validAdminLogin == false) {
						System.out.println("This is admin feature. Please login with admin user & try again!");
						break;
					}
					adminService.fetchScoreById();
					break;
				}

				case 8: {
					if (validAdminLogin == false) {
						System.out.println("This is admin feature. Please login with admin user & try again!");
						break;
					}
					adminService.addQuestions();
					break;
				}

				case 9: {
					System.out.println("Admin Login");
					validAdminLogin = adminService.adminLogin();
					break;
				}

				case 10: {
					System.out.println("Exiting quiz");
					return;
				}

				default:
					System.out.println("Incorrect choice !!!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("!!!!  Thank you for using program !!!!!");
		}
	}
}
