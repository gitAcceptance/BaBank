package babank;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 448465847248322208L;
	String userName;
	String password;
	String name;
	
	UserType type;

	public User(String userName, String password, String name, UserType type) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.type = type;
	}
	
	
	
}
