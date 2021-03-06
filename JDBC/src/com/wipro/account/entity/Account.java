package com.wipro.account.entity;

public abstract class Account 
{ private int accountNumber;
  private String holdersFirstName;
  private String holdersLastName;
  private String dateOfBirth;
  private float accountBalance;
  
public Account(int accountNumber, String holdersFirstName,
		String holdersLastName, String dateOfBirth, float accountBalance) {
	super();
	this.accountNumber = accountNumber;
	this.holdersFirstName = holdersFirstName;
	this.holdersLastName = holdersLastName;
	this.dateOfBirth = dateOfBirth;
	this.accountBalance = accountBalance;
}

public int getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

public String getHoldersFirstName() {
	return holdersFirstName;
}

public void setHoldersFirstName(String holdersFirstName) {
	this.holdersFirstName = holdersFirstName;
}

public String getHoldersLastName() {
	return holdersLastName;
}

public void setHoldersLastName(String holdersLastName) {
	this.holdersLastName = holdersLastName;
}

public String getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public float getAccountBalance() {
	return accountBalance;
}

public void setAccountBalance(float accountBalance) {
	this.accountBalance = accountBalance;
}
  
 public boolean Deposit(float amount)
 {
	return true; 
 }
 
 public abstract boolean withdraw(float amount);

}
