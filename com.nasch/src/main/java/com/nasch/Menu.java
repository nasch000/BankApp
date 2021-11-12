
package com.nasch;

import java.util.*;

import com.nasch.Account.Account;
import com.nasch.Account.AccountDAOImpl;
import com.nasch.Login.Login;
import com.nasch.Login.LoginDAOImpl;
import com.nasch.User.User;
import com.nasch.User.UserDAOImpl;

public class Menu {
	// Method for creating an account
	public void accountSignup(Database DB) {
		Scanner read = new Scanner(System.in);
		
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		
		Login newLogin = new Login();
		User newUser = new User();
		
		boolean accountProcessed = false;
		boolean userIDCheck = false;
		String firstName = null;
		String lastName = null;
		String eMail = null;
		String phoneNumber = null;
		String homeAddress = null;
		int userID = 0;
		String userName = null;
		String passWord = null;
		String confirmPass = null;
		
		int userInput = 0;
		while (userInput != 2) {
			
			System.out.println(" --- Enter 1: Continue Attempt ");
			System.out.println(" --- Enter 2: Return ");
			
			System.out.println(" --- Enter Number: ");
			
			userInput = 0;
			userInput = read.nextInt();
			if (userInput < 1 || 2 < userInput) {
				System.out.println(" --- Invalid input ");
				
			}
			else if (userInput == 1) {
				while (accountProcessed == false) {
					userID = (int) (Math.random() * 100000000);
					System.out.println(" --- First Name: ");
					firstName = read.next();
					System.out.println(" --- Last Name: ");
					lastName = read.next();
					System.out.println(" --- E-mail: ");
					eMail = read.next();
					System.out.println(" --- Phone-Number: ");
					phoneNumber = read.next();
					System.out.println(" --- Home Address: ");
					homeAddress = read.nextLine();
					read.nextLine();
					System.out.println(" --- Username: ");
					userName = read.next();
					System.out.println(" --- Password: ");
					passWord = read.next();
					System.out.println(" --- Confirm Password: ");
					confirmPass = read.next();
					
					if (firstName == null &&
						lastName == null &&
						eMail == null &&
						phoneNumber == null &&
						homeAddress == null &&
						userName == null &&
						passWord != confirmPass) {
						
						if (firstName == null) System.out.println(" --- First Name Required ");
						if (lastName == null) System.out.println(" --- Last Name Required ");
						if (eMail == null) System.out.println(" --- E-Mail Required ");
						if (phoneNumber == null) System.out.println(" --- Phone Number Required ");
						if (homeAddress == null) System.out.println(" --- Home Address Required ");
						if (userName == null) System.out.println(" --- Username Required ");
						if (passWord != confirmPass) System.out.println(" --- Passwords must match ");
						
					}
					else {
						while (userIDCheck == false) {
							for (int i = 0; i < DB.getUserList().size(); ++i) {
								if ( userID == DB.getUserList().get(i).getID() ) {
									userID = (int) (Math.random() * 100000000);
								}
								else {
									userIDCheck = true;
								}
							}
						}
						newUser.setID(userID);
						newUser.setFullname(firstName + " " + lastName);
						newUser.setEmail(eMail);
						newUser.setNumber(phoneNumber);
						newUser.setAddress(homeAddress);
						
						newLogin.setID(userID);
						newLogin.setUsername(userName);
						newLogin.setEmail(eMail);
						newLogin.setPass(passWord);
						
						userDAO.addUser(newUser);
						loginDAO.addLogin(newLogin);

						accountProcessed = true;
						
					}
					
				}
				
			}
			else if (userInput == 2) {
				System.out.println(" --- Returning ");
				
			}
			
		}
		
	}
	
	// Method for logging into an account
	public boolean accountLogin(Database data) {
		Scanner read = new Scanner(System.in);
		List<Account> accountList = data.getAccountList();
		List<Login> loginList = data.getLoginList();
		List<User> userList = data.getUserList();
		
		String username = null;
		String password = null;
		
		// Counts failed login attempts
		// int attempts = 0;
		
		System.out.println(" --- Please enter your username and password --- ");
		
		int userInput = 0;
		while (userInput != 2) {
			
			System.out.println(" --- Enter 1: Continue Attempt");
			System.out.println(" --- Enter 2: Return ");
			
			System.out.println(" --- Enter Number: ");
			
			userInput = 0;
			userInput = read.nextInt();
			if (userInput < 1 || 2 < userInput) {
				System.out.println(" --- Invalid input ");
				
			}
			else if (userInput == 1) {
				
				System.out.println(" --- Username: ");
				username = read.next();
				
				System.out.println(" --- Password: ");
				password = read.next();
				
				for (int i = 0; i < loginList.size(); i++) {
					if (username.equals(loginList.get(i).getUsername() ) && password.equals(loginList.get(i).getPass() ) ) {
						data.setLogin(loginList.get(i));
						data.setUser(userList.get(i));
						for (int j = 0; j < accountList.size(); j++) {
							if (userList.get(i).getFullname() == accountList.get(j).getFullname()) data.addAccount(accountList.get(j));
							
						}
						return true;
						
					}
					
				}
				System.out.println(" --- The username or password inputted is incorrect");

			}
			else if (userInput == 2) {
				System.out.println(" --- Returning ");
				
			}
			
		}
		
		return false;
		
	}
	
	// View account types and balances
	public void balanceActions(List<Account> accounts) {
		Scanner read = new Scanner(System.in);
		
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		
		int accountNum = 0;
		int userInput = 0;
		int actionNum = 0;
		while (userInput != 2) {
			
			System.out.println(" --- Enter 1: View an account");
			System.out.println(" --- Enter 2: Transfer amount");
			System.out.println(" --- Enter 3: Deposit amount");
			System.out.println(" --- Enter 4: Create account");
			System.out.println(" --- Enter 5: Return ");
			
			System.out.println(" --- Enter Number: ");
			
			accountNum = 0;
			userInput = 0;
			userInput = read.nextInt();
			if (userInput < 1 || 5 < userInput) {
				System.out.println(" --- Invalid input ");
				
			}
			else if (userInput == 1) {
				for (int i = 0; i < accounts.size(); i++) {
					System.out.print( (i + 1) + ": " + accounts.get(i).getType() + "  ");
					
				}
				System.out.println(" --- Enter Account Number: ");
				accountNum = read.nextInt();
				System.out.println("Account type: " + accounts.get(accountNum).getType());
				System.out.println("Balance: " + accounts.get(accountNum).getValue());
				
			}
			else if (userInput == 2) {
				for (int i = 0; i < accounts.size(); i++) {
					System.out.print( (i + 1) + ": " + accounts.get(i).getType() + "  ");
					
				}
				System.out.println(" --- Enter Account Number to Transfer from: ");
				int transferNum = read.nextInt();
				
				for (int i = 0; i < accounts.size(); i++) {
					System.out.print( (i + 1) + ": " + accounts.get(i).getType() + "  ");
					
				}
				System.out.println(" --- Enter Account Number to Transfer to: ");
				accountNum = read.nextInt();
				
				if (transferNum == accountNum) {
					System.out.println(" --- Cannot transfer from the same accounts");
					
				}
				else {
					System.out.println(" --- How much would you like to transfer? ");
					double transferBal = read.nextDouble();
					if (transferBal < 0) transferBal *= -1;
					if (accounts.get(transferNum).getValue() < transferBal) {
						System.out.println(" --- Failed trying to transfer an amount over the account's balance");
						
					}
					else {
						double newBalance = accounts.get(transferNum).getValue() - transferBal;
						accounts.get(transferNum).setOldValue(accounts.get(transferNum).getValue());
						accounts.get(transferNum).setValue(newBalance);
						double newBalance2 = accounts.get(accountNum).getValue() + transferBal;
						accounts.get(accountNum).setOldValue(accounts.get(accountNum).getValue());
						accounts.get(accountNum).setValue(newBalance2);
						accountDAO.updateAccount(accounts.get(transferNum));
						accountDAO.updateAccount(accounts.get(accountNum));
						
					}
					
				}
				
			}
			else if (userInput == 3) {
				for (int i = 0; i < accounts.size(); i++) {
					System.out.print( (i + 1) + ": " + accounts.get(i).getType() + "  ");
					
				}
				System.out.println(" --- Enter Account Number: ");
				accountNum = read.nextInt();
				System.out.println(" --- How much would you like to transfer? ");
				double transferBal = read.nextDouble();
				if (transferBal < 0) transferBal *= -1;
				if (accounts.get(accountNum).getValue() < transferBal) {
					System.out.println(" --- Failed trying to transfer an amount over the account's balance");
				}
				else {
					double newBalance = accounts.get(accountNum).getValue() + transferBal;
					accounts.get(accountNum).setOldValue(accounts.get(accountNum).getValue());
					accounts.get(accountNum).setValue(newBalance);
					accountDAO.updateAccount(accounts.get(accountNum));
					
				}
				
			}
			else if (userInput == 4) {
				System.out.println(" --- Account Types: ");
				System.out.println(" --- 1: Savings");
				System.out.println(" --- 2: Checking");
				System.out.println(" --- 3: Return");
				
				actionNum = read.nextInt();
				if (actionNum < 0 || 3 < actionNum) {
					System.out.println(" --- Invalid input ");
					
				}
				else if (actionNum == 1) {
					System.out.println(" --- Deposit how much into new account?");
					double newBalance = read.nextDouble();
					if (newBalance < 0) newBalance *= -1;
					Account newAccount = new Account();
					newAccount.setFullname(accounts.get(0).getFullname());
					newAccount.setType("Savings");
					newAccount.setValue(newBalance);
					accounts.add(newAccount);
					accountDAO.addAccount(newAccount);
					
				}
				else if (actionNum == 2) {
					System.out.println(" --- Deposit how much into new account?");
					double newBalance = read.nextDouble();
					if (newBalance < 0) newBalance *= -1;
					Account newAccount = new Account();
					newAccount.setFullname(accounts.get(0).getFullname());
					newAccount.setType("Checking");
					newAccount.setValue(newBalance);
					accounts.add(newAccount);
					accountDAO.addAccount(newAccount);
					
				}
				else {
					System.out.println(" --- Returning");
				}
				
			}
		
		}
		
	}
	
	// View and edit password
	public void securityActions(Login login) {
		Scanner read = new Scanner(System.in);
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		
		int input = 0;
		String returnStr = "1";
		String inputStr = null;
		String checkStr = null;
		while (input != 2) {
			System.out.println("Username: " + login.getUsername());
			System.out.println("Password: **********");
			
			System.out.println(" --- Press 1: Change password");
			System.out.println(" --- Press 2: Return");
			
			input = read.nextInt();
			if (input < 1 || 2 < input) {
				System.out.println("Please enter a valid number");
			}
			else if (input == 1) {
				System.out.println("Type 1: Return");
				System.out.println("Enter current password: ");
				
				int inputChange = 0;
				int inputReturn = 0;
				while (inputReturn == 0) {
					inputStr = read.nextLine();
					if (inputStr.equals(returnStr)) {
						inputChange = 0;
						inputReturn = 1;
						
					}
					if (inputStr.equals(login.getPass())) {
						while (inputChange == 0) {
							System.out.println("Enter new password :");
							inputStr = read.next();
							
							System.out.println("Confirm new password: ");
							checkStr = read.next();
							
							if (inputStr.equals(checkStr)) {
								login.setPass(inputStr);
								loginDAO.updateLogin(login);
								inputChange = 1;
								inputReturn = 1;
								
							}
							else {
								System.out.println("Passwords do not match");
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	// View and edit profile
	public void profileActions(User user) {
		Scanner read = new Scanner(System.in);
		UserDAOImpl userDAO = new UserDAOImpl();
		
		int input = 0;
		String inputStr = null;
		while (input != 5) {
			System.out.println("User Identification : " + user.getID());
			System.out.println("           Fullname : " + user.getFullname());
			System.out.println("     E-mail Address : " + user.getEmail());
			System.out.println("       Phone Number : " + user.getNumber());
			System.out.println("       Home Address : " + user.getAddress());
			
			System.out.println(" --- Press 1: Edit name");
			System.out.println(" --- Press 2: Edit E-mail address");
			System.out.println(" --- Press 3: Edit phone number");
			System.out.println(" --- Press 4: Edit home address");
			System.out.println(" --- Press 5: Return");
			
			input = read.nextInt();
			if (input < 1 || 5 < input) {
				System.out.println("Please enter a valid number");
			}
			else if (input == 1) {
				System.out.println("Enter new name: ");
				inputStr = read.nextLine();
				user.setFullname(inputStr);
				userDAO.updateUser(user);
			}
			else if (input == 2) {
				System.out.println("Enter new E-mail address; ");
				inputStr = read.nextLine();
				user.setEmail(inputStr);
				userDAO.updateUser(user);
			}
			else if (input == 3) {
				System.out.println("Enter new phone number: ");
				inputStr = read.nextLine();
				user.setNumber(inputStr);
				userDAO.updateUser(user);
			}
			else if (input == 4) {
				System.out.println("Enter new home address: ");
				inputStr = read.nextLine();
				user.setAddress(inputStr);
				userDAO.updateUser(user);
			}
		}
	}
}
