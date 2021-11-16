package com.nasch;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.*;

import org.junit.*;

import com.nasch.Account.Account;
import com.nasch.Login.Login;
import com.nasch.User.User;

public class DatabaseTest {
	
	@Test
	public void testGetConnection() {
		Database test = new Database();
		
		try {
			Connection connect = test.getConnection();
			assertNotNull(connect);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
	@Test
	public void testGetAccountList() throws SQLException {
		Database test = new Database();
		test.setDatabase();
		
		Account account = test.getAccountList().get(0);
		
		assertEquals("Adam Smith", account.getFullname());
		
	}
	
	@Test
	public void testGetLoginList() {
		Database test = new Database();
		test.setDatabase();
		
		Login login = test.getLoginList().get(0);
		
		assertEquals(12345678, login.getID());
		
	}
	
	@Test
	public void testGetUserList() {
		Database test = new Database();
		test.setDatabase();
		
		User user = test.getUserList().get(0);
		
		assertEquals(12345678, user.getID());
		
	}
	
	@Test
	public void testGetAccounts() {
		Database test = new Database();
		test.setDatabase();
		
		List<Account> accountList = test.getAccountList();
		test.addAccount(accountList.get(0));
		
		Account currentAccount = new Account();
		currentAccount = test.getAccounts().get(0);
		
		assertEquals("Adam Smith", currentAccount.getFullname());
		
	}
	
	@Test
	public void testGetLogin() {
		Database test = new Database();
		test.setDatabase();
		
		List<Login> loginList = test.getLoginList();
		
		test.setLogin(loginList.get(0));
		
		Login currentLogin = test.getLogin();
		
		assertEquals(12345678, currentLogin.getID());
		
	}
	
	@Test
	public void testGetUser() {
		Database test = new Database();
		test.setDatabase();
		
		List<User> userList = test.getUserList();
		
		test.setUser(userList.get(0));
		
		User currentUser = test.getUser();
		
		assertEquals(12345678, currentUser.getID());
		
	}
	
	@Test
	public void testAddAccount() {
		Database test = new Database();
		test.setDatabase();
		
		List<Account> accountList = test.getAccountList();
		test.addAccount(accountList.get(0));
		
		assertEquals(1, test.getAccounts().size());
		
	}

}
