
package com.nasch.User;

import java.sql.*;
import java.util.*;

import com.nasch.Database;

	/* Create a Data Access Object Interface and Implementation class which
	 * contains an add, remove, delete, and update method for at least one of
	 * your database tables
	 * • The DAO code should leverage an associated model class created in the
	 * previous milestone.
	 **/

public class UserDAOImpl implements UserDAO{
	
	public List<User> getUsers() {
		Database DB = new Database();
		
		List<User> userList = new ArrayList<User>();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "SELECT * FROM project.users";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				User user = new User();
				user.setID(result.getInt(1));
				user.setFullname(result.getString(2));
				user.setEmail(result.getString(3));
				user.setNumber(result.getString(4));
				user.setAddress(result.getString(5));
				userList.add(user);
				
			}
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
		return userList;
		
	}
	
	public void addUser(User user) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "INSERT INTO project.users "
				+ "VALUES(" + user.getID() + ", '" + user.getFullname() + "', '"
				+ user.getEmail() + "', " + user.getNumber() + ", '"
				+ user.getAddress() +"')";
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}

	public void updateUser(User user) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "UPDATE project.users SET userFullname = '" + user.getFullname()
				+ "' WHERE userID = " + user.getID() ;
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
			String query2 = "UPDATE project.users SET userEmail = '" + user.getEmail()
				+ "' WHERE userID = " + user.getID();
			Statement statement2 = connect.createStatement();
			statement2.executeUpdate(query2);
			
			String query3 = "UPDATE project.users SET phoneNumber = '" + user.getNumber()
				+ "' WHERE userID = " + user.getID();
			Statement statement3 = connect.createStatement();
			statement3.executeUpdate(query3);
			
			String query4 = "UPDATE project.users SET homeAddress = '" + user.getAddress()
				+ "' WHERE userID = " + user.getID();
			Statement statement4 = connect.createStatement();
			statement4.executeUpdate(query4);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}

	public void deleteUser(User user) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "DELETE from project.users WHERE userID = "
				+ user.getID();
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}

}
