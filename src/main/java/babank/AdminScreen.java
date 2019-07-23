package babank;

import java.util.HashMap;

public class AdminScreen {

	static void adminMenu(Admin user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		int adminOption;
		do {	
			System.out.println("************************************");
			System.out.println("** Welcome to Community Bank B.A. **");  //<--Prints welcome message
			System.out.println("************************************");

			System.out.println("\nHello " + user.name + "!");
			System.out.println("Please type either 1, 2, 3, 4, 5 to active the following: ");  //<--Asks Admin what they'd like to do
			System.out.println("(1)Make new Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout");

			adminOption = UserInput.isInt();  //<--Stores input into int

			//Checks that input was one of the listed options
			while(adminOption != 1 & adminOption != 2 & adminOption != 3 & adminOption != 4 & adminOption != 5) {
				System.out.println("\n**************************");
				System.out.println("Invalid menu option." );
				System.out.println("Please enter: (1)New Account  (2)Withdraw  (3)Deposit  (4)Transfer  (5)Close Account   (6)Logout" );
				adminOption = UserInput.isInt();
			}

			switch(adminOption) {  //<--Executes the method chosen by the user
			case 1:
				//UserActions.adminApproval
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
				//UserActions.accountClose();
				break;
			case 6:
				Logout.save(accounts, users);  //<--Saves all user's data into a file
				System.out.println("\n\nThanks for your dedication " + user.name + "!");
				System.out.println("\n***********************");
				System.out.println("** Logout Successful **");  //<--Prints goodbye screen
				System.out.println("***********************");
				break;
			}

		}while(adminOption != 6);

	}//end adminMenu()

}//end AdminScreen
