
package com.nasch.Account;

public class Account {
	
	private String userFullname = null;
	private String accountType = null;
	private double accountValue = 0;
	private double previousValue = 0;
	
	// UserFullname getter and setter
	public String getFullname() {
		return userFullname;
	}
	
	public void setFullname(String Fullname) {
		this.userFullname = Fullname;
	}
	
	// AccountType getter and setter
	public String getType() {
		return accountType;
	}
	
	public void setType(String Type) {
		this.accountType = Type;
	}
	
	// AccountValue getter and setter
	public double getValue() {
		return accountValue;
	}
	
	public void setValue(double Value) {
		this.accountValue = Value;
	}
	
	// Getter and setter of previous balance
	public double getOldValue() {
		return previousValue;
	}
	
	public void setOldValue(double Value) {
		this.previousValue = Value;
	}
	
}
