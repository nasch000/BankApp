
package com.nasch;

import java.sql.*;
import java.util.*;

import com.nasch.Account.Account;
import com.nasch.Account.AccountDAOImpl;
import com.nasch.Login.Login;
import com.nasch.Login.LoginDAOImpl;
import com.nasch.User.User;
import com.nasch.User.UserDAOImpl;

	/* This class should use login credentials for a user that you create using
	 * DDL and DCL to allow for access to part or all your database tables and
	 * schemas
	 **/

public class Database {
	
	private List<Account> accountList = new ArrayList<Account>();
	private List<Login> loginList = new ArrayList<Login>();
	private List<User> userList = new ArrayList<User>();
	
	private List<Account> currentAccountList = new ArrayList<Account>();
	private Login currentLogin = new Login();
	private User currentUser = new User();
	
	public Connection getConnection() throws SQLException {
		final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
		final String USER = "postgres";
		final String PASS = "*Imlucky08";
		
		return DriverManager.getConnection(DB_URL, USER, PASS);
		
	}
	
	public void connectTest() {
		try {
			Connection connect = getConnection();
			
			if (connect != null) System.out.println("Successfully connected to database");
			
		} catch (Exception e) {
			System.out.println("Connection to database is unsuccessful");
			
		}
		
	}
	
	public List<Account> getAccountList() {
		return accountList;
	}
	
	public List<Login> getLoginList() {
		return loginList;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void setDatabase() {
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		UserDAOImpl userDAO = new UserDAOImpl();
		
		try {
			accountList = accountDAO.getAccounts();
			loginList = loginDAO.getLogins();
			userList = userDAO.getUsers();
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}
	
	public List<Account> getAccounts() {
		return currentAccountList;
	}
	
	public Login getLogin() {
		return currentLogin;
	}
	
	public User getUser() {
		return currentUser;
	}
	
	public void addAccount(Account account) {
		this.currentAccountList.add(account);
	}
	
	public void setLogin(Login login) {
		this.currentLogin = login;
	}
	
	public void setUser(User user) {
		this.currentUser = user;
	}
	
}
