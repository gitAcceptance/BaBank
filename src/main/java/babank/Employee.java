package babank;

import java.io.Serializable;

public class Employee extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8410867601103903340L;
	
	
	
	public Employee(String userName, String password, String name, UserType type) {
		super(userName, password, name, type);
	}

}
