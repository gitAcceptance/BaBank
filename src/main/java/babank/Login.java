package babank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class Login{

	public static void main(String[] args) {

		//Line 16-76: Load in User & Account info
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
			}catch (EOFException e) {
			}catch (IOException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		if (usersFileFound) {
			ObjectInputStream usersInStream;
			try {
				usersInStream = new ObjectInputStream(userFile);
				users = (HashMap<String, User>) usersInStream.readObject();
			}catch (EOFException e) {
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		Random rand = new Random();
		int key = rand.nextInt(10000000);

		if(!accounts.containsKey(key) && accountsFileFound) {
			accounts.put(Integer.valueOf(key), new Account(key, LocalDateTime.now(), AccountType.CHECKING));
		}
		//HASH MAP LOADING COMPLETE


//################################################################################################################################
//################################################################################################################################
		
		
//--------------------------------------------Registration & Login Selection--------------------------------------------------------------------
		//Prints welcome screen
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank B.A. **");
		System.out.println("************************************");

		System.out.println("\nPlease type either 1 or 2 to active the following: "); //<--Prompts user to Register or Login
		System.out.println("(1)Register as a New User  (2)Login as Prexisting Users  ");  

		int login = UserInput.isInt(); //<--Tests users input for int and stores it

		//If user's input exceeds the menu options, they will be reprompted to select a menu option
		while(login != 1 & login != 2) {
			System.out.println("**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter (1)Register or (2)Login." );
			login = UserInput.isInt();
		}

		
//--------------------------------------------Registration--------------------------------------------------------------------------------
		if(login == 1) {
			
			//Username
			System.out.println("\n**************************");
			System.out.println("Please create a Username: ");  //<--Prompts user to create a username
			String username = UserInput.isString();  //<--Stores username into String

			//Checks if they created a unique username, reprompted to enter a new one if not
			while(users.containsKey(username)) {  
				System.out.println("\n**************************");
				System.out.println("This Username already exists. Please create a new Username: ");
				username = UserInput.isString();
			}

			
			//Password
			System.out.println("Please create a Password: ");
			String password = UserInput.isString();  //<--Stores password into String

			
			//Account Type
			//Asks what type of user they are
			System.out.println("Please enter 1, 2, or 3 for your profile type: ");
			System.out.println("(1)Customer  (2)Employee  (3)Admin");  //<--Employee & Admin will need approval
			int userType = UserInput.isInt();  //<--Store type into int
			
			//Checks if they entered a number outside the suggested range 
			while(userType != 1 & userType != 2 & userType != 3) {
				System.out.println("\n**************************");
				System.out.println("Invalid account type.");
				System.out.println("Please enter: (1)Customer  (2)Employee  (3)Admin" );
				userType = UserInput.isInt();
			}
			
			
			//Name
			//Asks the user for their full name
			System.out.println("Please enter your full name: ");
			String name = UserInput.isString();  //<--Stores name into String
			
			
//--------------------------------------------Registration CUSTOMER--------------------------------------------------------------------------------
			
			UserType type; //<--Create type variable that will be instantiated in user type
			
			//Creates customer account
			if(userType == 1) {
				
				//Asks for customer's phone #
				System.out.println("Please input your phone number (without space or special characters.");
				System.out.println("Example: 5554738291");
				long phone = UserInput.isLong();  //<--Stores number into long
				
				//Checks if they entered a full phone number
				while(String.valueOf(phone).length() != 10) {
					System.out.println("\n**************************");
					System.out.println("Invalid phone number.");
					System.out.println("Please input your phone number (without space or special characters.");
					System.out.println("Example: 5554738291");
					phone = UserInput.isLong();
				}
				
				//Stores CUSTOMER type into variable
				type = UserType.CUSTOMER;
				
				//Makes a new instance of Customer with all parameters filled out previously
				users.put(username, new Customer(username, password, name, type, phone));
				
				//Loads in a method to display the customer menu options
				CustomerScreen.customerMenu((Customer)users.get(username), accounts, users);  //<--Loads in a method to display the customer menu options
			}

			
//--------------------------------------------Registration EMPLOYEE--------------------------------------------------------------------------------
			//Employee account
			else if(userType == 2) {
				
				//Stores EMPLOYEE type into variable
				type = UserType.EMPLOYEE;
				
				//Makes a new instance of Customer with all parameters filled out previously
				users.put(username, new Employee(username, password, name, type));
				
				//Loads in a method to display the customer menu options
				EmployeeScreen.employeeMenu((Employee)users.get(username), accounts, users);  //<--Loads in a method to display the employee menu options
			}
		
			
//--------------------------------------------Registration ADMIN--------------------------------------------------------------------------------
			else if(userType == 3) {
				
				//Stores ADMIN type into variable
				type = UserType.ADMIN;
				
				//Makes a new instance of Customer with all parameters filled out previously
				users.put(username, new Admin(username, password, name, type));
				
				//Loads in a method to display the customer menu options
				AdminScreen.adminMenu((Admin)users.get(username), accounts, users);  //<--Loads in a method to display the admin menu options
			}
			
		}//end Registration

		
//--------------------------------------------Login Username & Password--------------------------------------------------------------------------------
		//Login prexisting users
		else if(login == 2) {
			
			//Username
			System.out.println("\n**************************");
			System.out.println("Please enter your Username: ");  //<--Prompts user to enter their username
			String username = UserInput.isString();  //<--Stores username into String

			//Checks if user entered a valid username
			while(!users.containsKey(username)) {  
				System.out.println("\n**************************");
				System.out.println("The Username given was not found. Please reenter your Username: ");
				username = UserInput.isString();
			}
			
			
			//Password
			System.out.println("Please enter your Password: ");
			String password = UserInput.isString();  //<--Stores password into String
			
			//Checks if user's password matches the one tied to their username/account
			while(!users.get(username).password.equals(password)) {
				System.out.println("\n**************************");
				System.out.println("Password did not match the Username. Please reenter your Password: ");
			}
			
			
//--------------------------------------------Login CUSTOMER, EMPLOYEE, & ADMIN--------------------------------------------------------------------------------

			//CUSTOMER
			if(users.get(username).type == UserType.CUSTOMER) {
				CustomerScreen.customerMenu((Customer)users.get(username), accounts, users);  //<--Loads in a method to display the customer menu options
			}
			
			//EMPLOYEE
			else if(users.get(username).type == UserType.EMPLOYEE) {
				EmployeeScreen.employeeMenu((Employee)users.get(username), accounts, users);  //<--Loads in a method to display the employee menu options
			}
			
			//ADMIN
			else {
				AdminScreen.adminMenu((Admin)users.get(username), accounts, users);  //<--Loads in a method to display the admin menu options
			}
			
		}//end Login

	}//end main

}//end Login class
