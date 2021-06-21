package com.wipro.account.entity;

public class CurrentAccount extends Account 
{ private float overdraft;
  
 public CurrentAccount(int accountNumber, String holdersFirstName,
		String holdersLastName,String dateOfBirth, float accountBalance,
		float overdraft) 
 {
	super(accountNumber, holdersFirstName, holdersLastName, dateOfBirth,
			accountBalance);
	this.overdraft = overdraft;
 }
 
  

	public float getOverdraft() {
	return overdraft;
    }
    public void setOverdraft(float overdraft) {
	this.overdraft = overdraft;
    }

    @Override
	public boolean withdraw(float amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
