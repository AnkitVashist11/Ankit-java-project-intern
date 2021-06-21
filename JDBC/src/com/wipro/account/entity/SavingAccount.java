package com.wipro.account.entity;

public class SavingAccount extends Account 
{
 private float minimumBalance;
 
  public SavingAccount(int accountNumber, String holdersFirstName,
		String holdersLastName,String dateOfBirth, float accountBalance,
		float minimumBalance) {
	super(accountNumber, holdersFirstName, holdersLastName, dateOfBirth,
			accountBalance);
	this.minimumBalance = minimumBalance;
}
  

	public float getMinimumBalance() {
	return minimumBalance;
}


public void setMinimumBalance(float minimumBalance) {
	this.minimumBalance = minimumBalance;
}


	@Override
	public boolean withdraw(float amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
