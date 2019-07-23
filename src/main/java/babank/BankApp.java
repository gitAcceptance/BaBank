package babank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BankApp {

	public static String[] login() {
		System.out.println("Please enter your user name.");
		Scanner in = new Scanner(System.in);
		String userName = in.nextLine();
		System.out.println("Please enter your password.");
		String userPass = in.nextLine();

		return new String[] {userName, userPass};
	}

	public static void customerLogin(String[] loginInfo) {


	}

	public static void employeeLogin(String[] loginInfo) {


	}

	public static void adminLogin(String[] loginInfo) {

	}

	public static void main(String[] args) {
		// Gonna need to load up our user data and account data first methinks.
		HashMap<Integer, Account> accounts = null;
		HashMap<String, User> users = null;

		boolean accountsFileFound = true;
		boolean usersFileFound = true;
		FileInputStream accountFile = null;
		FileInputStream userFile = null;

		try {
			accountFile = new FileInputStream("Accounts.ser");
		} catch (FileNotFoundException e) {
			System.out.println("Account info file not found, initializing blank account list.");
			accounts = new HashMap<Integer, Account>();
			accountsFileFound = false;
		}

		try {
			userFile = new FileInputStream("Users.ser");
		} catch (FileNotFoundException e) {
			System.out.println("User info file not found, initializing default user list.");
			users = new HashMap<String, User>();
			users.put("admin", new Admin());
			usersFileFound = false;
		}

		if (accountsFileFound) {
			ObjectInputStream accountInStream;
			try {
				accountInStream = new ObjectInputStream(accountFile);
				accounts = (HashMap<Integer, Account>) accountInStream.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (usersFileFound) {
			ObjectInputStream usersInStream;
			try {
				usersInStream = new ObjectInputStream(accountFile);
				users = (HashMap<String, User>) usersInStream.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Random rand = new Random();
		int key = rand.nextInt(10000000);

		if(!accounts.containsKey(key) && accountsFileFound) {
			accounts.put(Integer.valueOf(key), new Account(key, LocalDateTime.now(), AccountType.CHECKING));
		}
		// HASH MAP LOADING COMPLETE








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

}
