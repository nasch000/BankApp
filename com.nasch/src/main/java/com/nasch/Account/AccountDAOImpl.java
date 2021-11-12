
package com.nasch.Account;

import java.sql.*;
import java.util.*;

import com.nasch.Database;

public class AccountDAOImpl implements AccountDAO{
	
	public List<Account> getAccounts() {
		Database DB = new Database();
		
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "SELECT * FROM project.accounts";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				Account account = new Account();
				account.setFullname(result.getString(1));
				account.setType(result.getString(2));
				account.setValue(result.getInt(3));
				accountList.add(account);
				
			}
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
		return accountList;
		
	}

	public void addAccount(Account account) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "INSERT INTO project.accounts "
					+ "VALUES('" + account.getFullname() + "', '" + account.getType() + "', "
					+ account.getValue() + ")";
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
	}

	public void updateAccount(Account account) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "UPDATE project.accounts SET accountValue = "
				+ account.getValue() + " WHERE userFullname = '"
				+ account.getFullname() + "' AND accountType = '"
				+ account.getType() + "' AND accountValue = "
				+ account.getOldValue();
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}

	public void deleteAccount(Account account) {
		Database DB = new Database();
		
		try {
			Connection connect = DB.getConnection();
			
			String query = "DELETE from project.accounts WHERE userFullname = '"
				+ account.getFullname() + "' AND accountType = '"
				+ account.getType() + "' AND accountValue = "
				+ account.getValue();
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("An error was thrown during runtime");
			
		}
		
	}
	
}
