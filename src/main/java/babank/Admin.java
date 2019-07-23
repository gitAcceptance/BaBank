package babank;

import java.io.Serializable;

public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -341855397666258793L;
	
	public Admin() {
		super("admin", "admin", "Administrator Kevin", UserType.ADMIN);
	}

}
