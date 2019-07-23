package babank;

import java.io.Serializable;

public class Admin extends User implements Serializable {

	private static final long serialVersionUID = -341855397666258793L;
	
	public boolean isPendingApproval;
	
	public Admin() {
		super("admin", "admin", "Administrator Kevin", UserType.ADMIN);
		this.isPendingApproval = false;
	}
	
	public Admin(String userName, String password, String fullName, UserType type) {
		super(userName, password, fullName, type);
		this.isPendingApproval = true;
	}

}
