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
	
	public Account(int id, double balance, Date dateCreated, String accountType, boolean isOpen, Date dateClosed) {
		super();
		this.id = id;
		this.balance = balance;
		this.dateCreated = dateCreated;
		this.accountType = accountType;
		this.isOpen = isOpen;
		this.dateClosed = dateClosed;
	}

	public void withdraw(double dollars) {
		
	}
	
	public void transfer(double dollars, Account acc) {
		
	}
	
}
