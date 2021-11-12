
package com.nasch;

import java.sql.*;
import java.util.*;

import com.nasch.Account.Account;
import com.nasch.Login.Login;
import com.nasch.User.User;

/* Create a tester class which prints a message on establishing a successful
  * connection to the database
  * • Provide a screenshot showcasing that you have successfully connected to
  * your database
  **/

public class Main {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		Database DB = new Database();
		Menu menu = new Menu();
		
		List<Account> accounts = new ArrayList<Account>();
		Login login = new Login();
		User user = new User();
		
		//int count = 1;
		int userInput = 0;
		int menuInput = 0;
		try {
			Connection connect = DB.getConnection();
			DB.setDatabase();
			
			System.out.println(" ---           Welcome to New Bank!          --- ");
			while (menuInput != 3) {
				System.out.println("\n --- Press 1: Sign up ");
				System.out.println(" --- Press 2: Log in ");
				System.out.println(" --- Press 3: Exit Program ");
				
				System.out.println(" --- Enter Number: ");
				
				menuInput = 0;
				menuInput = read.nextInt();
				if (menuInput < 1 || 3 < menuInput) {
					System.out.println(" --- Invalid input");
					
				}
				else if (menuInput == 1) {
					menu.accountSignup(DB);
					
				}
				else if (menuInput == 2) {
					if (menu.accountLogin(DB)) {
						accounts = DB.getAccounts();
						login = DB.getLogin();
						user = DB.getUser();

						System.out.println("Welcome " );
						while (userInput != 4) {
							
							System.out.println(" --- What would you like to do? --- ");
							System.out.println(" --- Press 1: View account and balance");
							System.out.println(" --- Press 2: View and edit profile");
							System.out.println(" --- Press 3: View and edit security");
							System.out.println(" --- Press 4: Log out");
							
							userInput = 0;
							userInput = read.nextInt();
							if (userInput < 1 || 4 < userInput) {
								System.out.println("Please enter a valid number");
								
							}
							else if (userInput == 1) {
								menu.balanceActions(accounts);
								
							}
							else if (userInput == 2) {
								menu.profileActions(user);
								
							}
							else if (userInput == 3) {
								login.setOldPass(login.getPass());
								menu.securityActions(login);
								
							}
							else if (userInput == 4) {
								System.out.print(" --- Logged out successfully ");
								System.out.println(" --- Thank you and have a nice day! ");
								
							}
							
						}
						
					}
					
				}
				else {
					System.out.println(" --- Thank you and have a nice day! ");
					
				}
				
			}
			
			connect.close();
			read.close();
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
		/*
		Account user1 = new Account();
		user1.setID(12345678);
		user1.setFullname("Adam Smith");
		user1.setEmail("aSmith@hotmail.com");
		user1.setNumber("1-512-635-9236");
		user1.setAddress("8252 Rockwood Drive");
		
		user1.setUsername("adamSmith");
		user1.setPass("Smithsonian1963");
		
		user1.setType("Savings");
		user1.setValue(23858.08);
		
		Account user2 = new Account();
		user2.setID(87654321);
		user2.setFullname("Jane Smith");
		user2.setEmail("janeS@hotmail.com");
		user2.setNumber("1-512-825-5825");
		user2.setAddress("8252 Rockwood Drive");
		
		user2.setUsername("janeSmith");
		user2.setPass("amberjane00300");
		
		user2.setType("Savings");
		user2.setValue(19276.98);
		
		int login = 0;
		int action = 0;
		String inputUsername = null;
		String inputPassword = null;
		
		
		while (login != 3) {
			System.out.println(" --- What would you like to do? --- ");
			System.out.println(" --- Press 1: Create new account");
			System.out.println(" --- Press 2: Login");
			System.out.println(" --- Press 3: Exit Program");
			
			System.out.println(" --- Number: ");
			login =  read.nextInt();
			
			if (login < 1 || 3 < login) {
				System.out.println("Please enter a valid number");
			}
			else if (login == 1) {
				System.out.println("This is a work in progress");
			}
			else if (login == 2) {
				System.out.println("Username: ");
				inputUsername = read.next();
				
				System.out.println("Password: ");
				inputPassword = read.next();
				
				if (inputUsername.equals(user1.getUsername()) && inputPassword.equals(user1.getPass())) {
					System.out.println("Welcome " + user1.getFullname());
					while (action != 4) {
						System.out.println(" --- What would you like to do? --- ");
						System.out.println(" --- Press 1: View account and balance");
						System.out.println(" --- Press 2: View and edit profile");
						System.out.println(" --- Press 3: View and edit security");
						System.out.println(" --- Press 4: Log out");
						
						action = read.nextInt();
						if (action < 1 || 4 < action) {
							System.out.println("Please enter a valid number");
						}
						else if (action == 1) {
							user1.balanceActions();
						}
						else if (action == 2) {
							user1.profileActions();
						}
						else if (action == 3) {
							user1.securityActions();
						}
						else if (action == 4) {
							System.out.print("Logged out successfully");
							System.out.println("Thank you and have a nice day!");
						}
					}
				}
				else if (inputUsername.equals(user2.getUsername()) && inputPassword.equals(user2.getPass())) {
					System.out.println("Welcome " + user2.getFullname());
					while (action != 4) {
						System.out.println(" --- What would you like to do? --- ");
						System.out.println(" --- Press 1: View account and balance");
						System.out.println(" --- Press 2: View and edit profile");
						System.out.println(" --- Press 3: View and edit security");
						System.out.println(" --- Press 4: Log out");
						
						action = read.nextInt();
						if (action < 1 || 4 < action) {
							System.out.println("Please enter a valid number");
						}
						else if (action == 1) {
							user2.balanceActions();
						}
						else if (action == 2) {
							user2.profileActions();
						}
						else if (action == 3) {
							user2.securityActions();
						}
						else if (action == 4) {
							System.out.print("Logged out successfully");
							System.out.println("Thank you and have a nice day!");
						}
					}
				}
				else {
						System.out.println("The username or password you inputted is incorrect");
				}
			}
			else if (login == 3) {
				System.out.println("Thank you and have a nice day!");
			}
		} */
		
	}

}
