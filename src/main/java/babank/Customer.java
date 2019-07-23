package babank;

import java.io.Serializable;
import java.util.HashSet;

public class Customer extends User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3980819666127803352L;
	int phone;
	HashSet<Integer> accounts; // This will contain a list of all the account IDs that the user owns
	
	
	
	public Customer(String userName, String password, String name, UserType type, int phone) {
		super(userName, password, name, type);
		this.phone = phone;
		accounts = new HashSet<Integer>(); 
	}
	
	public void addAccount(int accountNumber) {
		accounts.add(Integer.valueOf(accountNumber));
	}
	
	
	/**
	 * Removes the account from the customer's list of accounts.
	 * 
	 * @param accountNumber
	 * @return Returns true if the account exists, and false otherwise.
	 */
	public boolean removeAccount(int accountNumber) {
		if (accounts.contains(Integer.valueOf(accountNumber))) {
			accounts.remove(Integer.valueOf(accountNumber));
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public static void applyForNewAccount() {
		
		
	}
	
	
	
	
	
	

}
