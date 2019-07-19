package com.revature.babank;

import java.time.LocalDateTime;
import java.util.Date;

public class Account {
	int id;
	double balance;
	LocalDateTime dateCreated;
	String accountType;
	
	// TODO transaction history
	
	boolean isOpen;
	
	Date dateClosed;
	// lets store who closed the account
	
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	LocalDateTime now = LocalDateTime.now();  
//	System.out.println(dtf.format(now));  
	
	public Account(int id, String accountType) {
		this(id, 0, LocalDateTime.now(), accountType, true, null);
	}
	
	
	
	
	public Account(int id, double balance, LocalDateTime dateCreated, String accountType, boolean isOpen, Date dateClosed) {
		super();
		this.id = id;
		this.balance = balance;
		
		
		
		this.dateCreated = dateCreated;
		this.accountType = accountType;
		this.isOpen = isOpen;
		this.dateClosed = dateClosed;
	}

	public void deposit(double dollars) {
		balance += dollars;
	}
	
	public void withdraw(double dollars) {
		balance = balance - dollars;
		return;
	}
	
	public void transfer(double dollars, Account acc) {
		balance = balance - dollars;
		acc.balance = acc.balance + dollars;
	}
	
}
