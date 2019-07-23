package babank;

import java.time.LocalDateTime;
import java.util.Date;

public class Account {
	int id;
	double balance;
	LocalDateTime dateCreated;
	AccountType type;
	
	
	// TODO transaction history
	
	boolean isOpen;
	boolean isPendingApproval;
	
	
	LocalDateTime dateClosed;
	// lets store who closed the account
	
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	LocalDateTime now = LocalDateTime.now();  
//	System.out.println(dtf.format(now));  
	
	
	
	public Account(int id, LocalDateTime dateCreated , AccountType type) {
		this(id, 0, dateCreated, type, false, true, LocalDateTime.of(2000, 1, 1, 0, 1));
	}
	
	
	public Account(int id, double balance, LocalDateTime dateCreated, AccountType type, boolean isOpen, boolean isPendingApproval, LocalDateTime dateClosed) {
		super();
		this.id = id;
		this.balance = balance;
		this.dateCreated = dateCreated;
		this.type = type;
		this.isOpen = isOpen;
		this.isPendingApproval = isPendingApproval;
		this.dateClosed = dateClosed;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
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
	
	public boolean isPendingApproval() {
		return isPendingApproval;
	}
	
	public void approve() {
		isOpen = true;
	}
	
	public void close() {
		isOpen = false;
		dateClosed = LocalDateTime.now();
	}
}
