
package com.nasch.User;

public class User {
	
	private int userID = 0;
	private String userFullname = null;
	private String userEmail = null;
	private String phoneNumber = null;
	private String homeAddress = null;
	
	// UserID getter and setter
	public int getID() {
		return userID;
	}
	
	public void setID(int ID) {
		this.userID = ID;
	}
	
	// UserFullname getter and setter
	public String getFullname() {
		return userFullname;
	}
	
	public void setFullname(String Fullname) {
		this.userFullname = Fullname;
	}
	
	// UserEmail getter and setter
	public String getEmail() {
		return userEmail;
	}
	
	public void setEmail (String Email) {
		this.userEmail = Email;
	}
	
	// PhoneNumber getter and setter
	public String getNumber() {
		return phoneNumber;
	}
	
	public void setNumber(String Number) {
		this.phoneNumber = Number;
	}
	
	// HomeAddress getter and setter
	public String getAddress() {
		return homeAddress;
	}
	
	public void setAddress(String Address) {
		this.homeAddress = Address;
	}
	
}
