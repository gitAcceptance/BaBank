package com.revature.babank;

import java.util.Date;

public class Account {
	int id;
	double balance;
	Date dateCreated;
	String accountType;
	
	//transaction history
	
	boolean isOpen;
	
	Date dateClosed;
	// lets store who closed the account
	
	public void deposit(double dollars) {
		
	}
	
	public void withdraw(double dollars) {
		
	}
	
	public void transfer(double dollars, Account acc) {
		
	}
	
}
