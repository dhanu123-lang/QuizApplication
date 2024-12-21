package com.miniproject.groupa.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.miniproject.groupa.util.DBUTILConnection;

public class StudentRegistration 
{	
	Connection con = null;
	PreparedStatement ps = null;
	
	 public static void registerStudent()
	 {
		 System.out.println("***** Welcome ***** \n" );
		 System.out.println("*** Rules and Regulation ***");
		 System.out.println("There are only 10 questions in this quiz \n");
		//System.out.println("Fetch the questions by question_id \n");
		 System.out.println("Each question will display only once \n");
		 
		 System.out.println("Enter your information \n");
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter FirstName >>> ");
		 String firstname = sc.nextLine();
		 
		 System.out.println("Enter LastName >>> ");
		 String lastname = sc.nextLine();
		 
		 System.out.println("Enter city >>> ");
		 String city = sc.nextLine();
		 
		 System.out.println("Enter Mail_id >>>");
		 String mail_id = sc.nextLine();
		 
		 System.out.println("Enter Mobile number >>> ");
		 String mobile_no = sc.nextLine();
		 
		 System.out.println("Enter UserName >>> ");
		 String username = sc.nextLine();
		 
		 System.out.println("Enter Password >>> ");
		 String password = sc.nextLine();
		 
		// sc.close();
		 
		 //Set value in student object
		 Student stud = new Student();
		 
		 stud.setFirst_name(firstname);
		 stud.setLast_name(lastname);
		 stud.setCity(city);
         stud.setMail_id(mail_id);	
         stud.setMobile_number(mobile_no);
         stud.setUser_name(username);
         stud.setPassword(password);
         
		storeStudentDataInDB(stud);/// static method in same class
       
	 }
	 
 
	 public static void storeStudentDataInDB(Student stud)
	 { 
	     	try {
				
				 Connection con = DBUTILConnection.getConnection();
				// Step-3. use preparedStatement
				 PreparedStatement    ps=con.prepareStatement("insert into student(first_name,last_name, city, mail_id, mobile_number, user_name, password)"
						+ "values(?,?,?,?,?,?,?)");
				
				ps.setString(1,stud.getFirst_name());
				ps.setString(2, stud.getLast_name());
				ps.setString(3, stud.getCity());
				ps.setString(4, stud.getMail_id());
				ps.setString(5, stud.getMobile_number());
				ps.setString(6,stud.getUser_name());
				ps.setString(7, stud.getPassword());
				
				
				// Step-4- submit SQL statement to database
				int a=ps.executeUpdate();
				// Step-5- process result
				System.out.println("Data insert successfully...."+a);
				
				con.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
}
