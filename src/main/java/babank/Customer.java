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
	}
	
	public static void addAccount() {
		
	}
	
	

	public void removeAccount() {
		
	}
	
	public static void applyForNewAccount() {
		
		
	}
	
	
	
	
	
	

}
