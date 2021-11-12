
package com.nasch.Login;

import java.sql.*;
import java.util.*;

import com.nasch.Database;

public class LoginDAOImpl implements LoginDAO{
	
	public List<Login> getLogins() {
		Database DB = new Database();
		
		List<Login> loginList = new ArrayList<Login>();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "SELECT * FROM project.login";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				Login login = new Login();
				login.setID(result.getInt(1));
				login.setUsername(result.getString(2));
				login.setEmail(result.getString(3));
				login.setPass(result.getString(4));
				loginList.add(login);
				
			}
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
		return loginList;
		
	}

	public void addLogin(Login login) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "INSERT INTO project.login "
					+ "VALUES(" + login.getID() + ", '" + login.getUsername() + "', '"
					+ login.getEmail() + "', '" + login.getPass() + "')";
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}

	public void updateLogin(Login login) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "UPDATE project.login SET userPass = '" + login.getPass()
				+ "' WHERE userID = " + login.getID() + " AND userPass = '"
				+ login.getOldPass() + "'";
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}

	public void deleteLogin(Login login) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "DELETE from project.login WHERE userID = "
				+ login.getID() + " AND userPass = '" + login.getPass() + "'";
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}
	
}
