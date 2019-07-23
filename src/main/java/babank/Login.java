package babank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class Login{

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


		//----------------------------------------------------------------------------------------
		//------------------------------------Login-----------------------------------------------
		//----------------------------------------------------------------------------------------

		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank B.A. **");
		System.out.println("************************************");

		System.out.println("\nPlease type either 1 or 2 to active the following: ");
		System.out.println("(1)Register as a New User  (2)Login as Prexisting Users  ");

		int login = UserInput.isInt();

		while(login != 1 & login != 2) {
			System.out.println("**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter (1)Register or (2)Login." );
			login = UserInput.isInt();
		}

		//Registration
		if(login == 1) {
			//Call Registration menu
			//Or call same username & password field, both check, but one adds to database
			System.out.println("\n**************************");
			System.out.println("Please enter a Username: " );
			String username = UserInput.isString();

			if(users.containsKey(username)) {
				//Loop username asking
			}

				//Check user name against database
				//Return error if already exists
			
			
				//Continue to password if not
			System.out.println("Please create a Password: " );
			String password = UserInput.isString();

			
			
			System.out.println("Please enter your account type: " );
			System.out.println("(1)Customer  (2)Employee  (3)Admin");
			int userType = UserInput.isInt();
			
			
			while(userType != 1 & userType != 2 & userType != 3) {
				System.out.println("\n**************************");
				System.out.println("Invalid account type.");
				System.out.println("Please enter: (1)Customer  (2)Employee  (3)Admin" );
				userType = UserInput.isInt();
			}
			
			
			
			
			//Enter user info
			System.out.println("Please enter your Name: " );
			String name = UserInput.isString();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			UserType type;
			


			//Customer account
			if(userType == 1) {
				
				System.out.println("Please input your phone number (without space or special characters."); //<--Need to get name
				System.out.println("Example: 5554738291");
				int phone = UserInput.isInt();
				//TODO Add check for length with proper input
				
				type = UserType.CUSTOMER;
				
				//Makes a new customer
				users.put(username, new Customer(username, password, name, type, phone));
				
				
				CustomerScreen.customerMenu((Customer)users.get(username));
			}

			//Employee account
			else if(userType == 2) {
				//Puts in request for approval
				//Run newEmployee();
				//Connect to employeeScreen;
			}

			else if(userType == 3) {
				//Puts in request for approval
				//Run newAdmin();
				//Connect to adminScreen;
			}
		}

		//Login
		else if(login == 2) {
			//Call Login menu
			//Or call same username & password field, both check, but one adds to database
			System.out.println("**************************");
			System.out.println("Please enter your username: " );
			String username = UserInput.isString();
			//Check user name against database
			//Return error if not already exists
			//Continue to password if not
			System.out.println("Please enter your password: " );
			String password = UserInput.isString();
			//Verify password is connected to username
			//If not, loop back through username & password

			//If successful, go onto to customer, employee, or admin screen
			/*
			 * if(something parsed == 1){
			 * 		run customerScreen();
			 * }
			 * if(something parsed == 2){
			 * 		run employeeScreen();
			 * }
			 * if(something parsed == 3){
			 * 		run adminScreen();
			 * }
			 */
		}

		//Call user main screen

	}//end main

}//end Menu class
