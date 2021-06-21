package com.wipro.account.exception;

public class InSufficiantFundsException extends Exception 
{
	public String toString()
	{
		return "not enough balance in your account";
	}
 
}
