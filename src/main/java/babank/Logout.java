package babank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Logout {

	public static void save(HashMap<Integer, Account> accounts, HashMap<String, User> users) {
		// SAVING OUR ACCOUNTS
		FileOutputStream accountFileOutStream = null;
		ObjectOutputStream accountObjectOut = null;
		try {
			accountFileOutStream = new FileOutputStream("Accounts.ser");
			accountObjectOut = new ObjectOutputStream(accountFileOutStream);
			accountObjectOut.writeObject(accounts);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



		// SAVING OUR USERS
		FileOutputStream userFileOutStream = null;
		ObjectOutputStream userObjectOut = null;
		try {
			userFileOutStream = new FileOutputStream("Users.ser");
			userObjectOut = new ObjectOutputStream(userFileOutStream);
			userObjectOut.writeObject(users);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		// CLOSING STREAMS
		if (accountObjectOut !=  null) {
			try {
				accountObjectOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (userObjectOut != null) {
			try {
				userObjectOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



		// CLOSING FILES
		if (accountFileOutStream != null) {
			try {
				accountFileOutStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (userFileOutStream != null ) {
			try {
				userFileOutStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}//end Logout class
