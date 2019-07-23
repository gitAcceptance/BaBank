package babank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class CustomerScreen {

		static void customerMenu(Customer user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {
			
		int customerOption;
		do {	
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank B.A. **");  //<--Prints welcome message
		System.out.println("************************************");

		System.out.println("\nHello " + user.name + "!");
		System.out.println("Please type either 1, 2, 3, 4, 5 to active the following: ");  //<--Asks Customer what they'd like to do
		System.out.println("(1)Make new Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout");

		customerOption = UserInput.isInt();  //<--Stores input into int

		//Checks that input was one of the listed options
		while(customerOption != 1 & customerOption != 2 & customerOption != 3 & customerOption != 4 & customerOption != 5) {
			System.out.println("\n**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter: (1)New Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout" );
			customerOption = UserInput.isInt();
		}

		//Executed the method chosen by the user
		switch(customerOption) {
		case 1:
			//Redirect to new Account screen
			break;
		case 2:
			UserActions.withdraw();
			break;
		case 3:
			UserActions.deposit();
			break;
		case 4:
			UserActions.transfer();
			break;
		case 5:
			Logout.save(accounts, users);  //<--Saves all user's data into a file
			System.out.println("\n\nThanks for visiting " + user.name + "!");
			System.out.println("\n***********************");
			System.out.println("** Logout Successful **");  //<--Prints goodbye screen
			System.out.println("***********************");
			break;
		}

		}while(customerOption != 5);
		
	}//end customerMenu

		
//------------------------------------Account-------------------------------------------
	static void addAccount() {
			
	}
		
		
		
	

		
}//end CustomerScreen