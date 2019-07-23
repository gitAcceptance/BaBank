package babank;

public class UserActions {


	//------------------------------------Add Account-------------------------------------------
	static void addAccount() {

	}//end addAccount()
	
	
	//------------------------------------View Account Info-------------------------------------------
	static void accountInfo() {

	}//end accountInfo()

	
	//------------------------------------View Account Balance-------------------------------------------
	static void accountBalance() {

	}//end accountBalance()


	//------------------------------------View Customer Info-------------------------------------------
	static void customerInfo() {

	}//end customerInfo()

	
	//------------------------------------Account Approval-------------------------------------------
	static void accountApproval() {

	}//end accountApproval()

	
	//------------------------------------Admin Approval-------------------------------------------
	static void adminApproval() {

	}//end adminApproval()

	
	//------------------------------------Close Account-------------------------------------------
	static void accountClose() {

	}//end addAccount()


	//------------------------------------Withdraw-------------------------------------------
	static void withdraw() {

		System.out.println("\n** Withdraw **");  //<--Displays action screen
		System.out.println("Here are your accounts: " );//<--TODO Load in all accounts   ID + Type + Balance
		//For loop to display all accounts they have

		System.out.println("\nPlease specify which account you'd like to withdraw from.");  //<--Asks user to specify account
		System.out.println("Enter a number " + "(numbers of accounts)"); //<--TODO Need list size

		//Need while loop to keep in scope
		int accountSelect = UserInput.isInt();
		//Get account at [accountSelection]
		//Save into variable

		System.out.println("\nThis account currently has " + "(balance)");  //<--Prints current balance to the user
		System.out.println("Please specify the amount you'd like to withdraw:");  //TODO<--Get balance of account

		//TODO Need while loop so not greater than balance
		double amount = Math.round(UserInput.isDouble() * 100) / 100d;

		//Balance -= amount;
		//Update balance

		System.out.println("\nYour withdrawl of " + amount + " was successful.");
		System.out.println("Your new balance is: " + "(balance)"); //<--Prints updated balance

	}//end withdraw()


	//------------------------------------Deposit------------------------------------------
	static void deposit() {

		System.out.println("\n** Deposit **");  //<--Displays action screen
		System.out.println("Here are your accounts: " );//<--Load in all accounts   ID + Type + Balance
		//For loop to display all accounts they have

		System.out.println("\nPlease specify which account you'd like to deposit into.");  //<--Asks user to specify account
		System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

		//Need while loop to keep in scope
		int accountSelect = UserInput.isInt();
		//Get account at [accountSelection]
		//Save into variable

		System.out.println("\nThis account currently has " + "(balance)"); //<--Get balance of account
		System.out.println("Please specify the amount you'd like to deposit:");

		double amount = Math.round(UserInput.isDouble() * 100) / 100d;

		//Balance += amount;
		//Update balance

		System.out.println("\nYour deposit of " + amount + " was successful."); 
		System.out.println("Your new balance is: " + "(balance)"); //<--Print updated balance

		//call customerMenu

	}//end deposit()


	//------------------------------------Transfer------------------------------------------
	static void transfer() {

		System.out.println("\n** Transfer **");  //<--Displays action screen
		System.out.println("Here are your accounts: " );//<--Load in all accounts   ID + Type + Balance
		//For loop to display all accounts they have

		System.out.println("\nPlease specify which account you'd like to transfer from.");  //<--Asks user to specify starting account
		System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

		//Need while loop to keep in scope
		int accountSelect = UserInput.isInt();
		//Get account at [accountSelection]
		//Save into variable

		System.out.println("\nPlease specify which account you'd like to transfer to.");
		System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

		//Need while loop to keep in scope
		int accountSelect2 = UserInput.isInt();
		//Get account at [accountSelection]
		//Save into variable

		System.out.println("\nYour account currently has " + "(balance)"); //<--Get balance of account
		System.out.println("Please specify the amount you'd like to transfer:");

		//Need while loop so not greater than balance
		double amount = Math.round(UserInput.isDouble() * 100) / 100d;

		//Balance -= amount;  <--accountSelect
		//Balance += amount;  <--accountSelect2
		//Update balances

		System.out.println("\nYour transfer of " + amount + " was successful."); 
		System.out.println("Your new balance is: " + "(balance)"); //<--Print updated balance of accountSelect

		//call customerMenu

	}//end transfer()

}//end UserActions class
