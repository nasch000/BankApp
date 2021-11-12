
package com.nasch.Login;

public class Login {
	
	private int userID = 0;
	private String userEmail = null;
	private String username = null;
	private String userPass = null;
	
	// Possible list of old passwords to warn user to make unique passes
	// Just one old pass for now
	private String oldUserPass = null;
	
	// UserID getter and setter
	public int getID() {
		return userID;
	}
	
	public void setID(int ID) {
		this.userID = ID;
	}
	
	// UserEmail getter and setter
	public String getEmail() {
		return userEmail;
	}
	
	public void setEmail (String Email) {
		this.userEmail = Email;
	}
	
	// Username getter and setter
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String Name) {
		this.username = Name;
	}
	
	// UserPass getter and setter
	public String getPass() {
		return userPass;
	}
	
	public void setPass(String Password) {
		this.userPass = Password;
	}
	
	// OldUserPass getter and setter
	public String getOldPass() {
		return oldUserPass;
	}
	
	public void setOldPass(String Password) {
		this.oldUserPass = Password;
	}
	
}
