package ultravision.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ultravision.interfaces.UserInterface;


public class User implements UserInterface{
	
	String custName = null;
	String returnTitle = null;
	private String[] title = new String[2];
	Rental rental;
	Customer cust1;
	Title titleName;
	String[] newCust = new String[2];
	String[] newTitle = new String[5];
	String[] newRental = new String[3];
	
	public User() {
		homeScreen();
	}
	
	@Override
	public void homeScreen() {
		System.out.println("############ WELCOME TO ULTRAVISION ############");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;
		try {
			
			System.out.println("Please select one option: \n"
					+ "(1) Search Customer\n"
					+ "(2) Search Title\n"
					+ "(3) Add Customer\n"
					+ "(4) Add Title\n"
					+ "(5) Update Customer Details\n"
					+ "(6) Rent a title \n"
					+ "(7) Return a title \n"
					);
			input = br.readLine();
	
			if(input.equals("1")) {
				findCustomer();
			}else if(input.equals("2")){
				findTitle();
			}else if(input.equals("3")){
				addCustomer();
			}else if(input.equals("4")){
				addTitle();
			}else if(input.equals("5")){
				updateCustomer();
			}else if(input.equals("6")){
				registerRental();
			}else if(input.equals("7")){
				registerReturn();
			}else {
				System.out.println("Invalid option. Please try again...");
				homeScreen();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void backToMenu() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		try {
			System.out.println("Would you like to return to the Main Menu?(Y/N)");
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(input.equals("Y") || input.equals("y")) {
			homeScreen();
		}else if(input.equals("N") || input.equals("n")) {
			System.out.println("Good Bye!");
		}else {
			System.out.println("That's not a valid option. Please try again...");
			backToMenu();
		}
	}
	
	@Override
	public void findCustomer() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			System.out.println("Please enter customer fullname: ");
			custName = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust1 = new Customer(custName);
		if(cust1.getName() == null) {
			System.out.println("Customer not found. Try a valid name...");
			findCustomer();
		}else {
			System.out.println(cust1 + "\n");
			backToMenu();
		}
	}
	
	@Override
	public void findTitle() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		System.out.println("Please enter Title type(1-Video, 2-CD, 3-Concert): ");
		try {
			input = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (input.equals("1") || input.equals("2") || input.equals("3")) {
			try {
				System.out.println("Please enter the title: ");
				title[0] = input;
				title[1] = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			titleName = new Title(title);
			titleName.searchTitle(title);
			backToMenu();
		}else {
			System.out.println("Invalid Option. Try again: ");
			findTitle();
		}
		
		
	}
	
	@Override
	public void addCustomer() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		int counter = 0;
		String [] columns = {"Fullname", "Membership Type"}; 
		try {
			do {
			System.out.println("Please enter the " + columns[counter]+ ": ");
			input = br.readLine();
			newCust[counter] = input;
			counter++;
			}while(counter < 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newCust[1].equals("VL")||newCust[1].equals("ML")
				||newCust[1].equals("TV")||newCust[1].equals("PR")) {
			cust1.addCustDB(newCust);
			backToMenu();
		}else {
			System.out.println("Wrong Membership Type. Please choose between: (ML)(VL)(TV)(PR)");
			addCustomer();
		}
		
	}
	
	@Override
	public void addTitle() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		int counter = 0;
		String [] columns = {}; 
		String[] moviesColumns = {"Media(Bluray, DVD or CD)", "Year of Release", "Title", "Genre", "Director"};
		String[] musicColumns = {"Year of Release", "Title", "Band"};
		String[] concertsColumns = {"Media", "Year of Release", "Title", "Band"};

		System.out.println("Please enter Title type(1-Video, 2-CD, 3-Concert): ");
		try {
			input= br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (input.equals("1")) {
			columns = moviesColumns;
		}else if(input.equals("2")) {
			columns = musicColumns;
		}else if(input.equals("3")) {
			columns = concertsColumns;
		}else if(input.equals("exit")){
			homeScreen();
		}else {
			System.out.println("Invalid type. Let's try again...");
			addTitle();
		}
		try {
			do {
			System.out.println("Please enter the " + columns[counter]+ ": ");
			input = br.readLine();
			newTitle[counter] = input;
			counter++;
			}while(counter < columns.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		titleName = new Title(title);
		titleName.addTitleDB(newTitle);
		backToMenu();
	}
	
	@Override
	public void updateCustomer() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		int counter = 0;
		String [] columns = {"Fullname", "Membership Type(VL, ML, TV or PR)"}; 
		try {
			do {
			System.out.println("Please enter the " + columns[counter]+ ": ");
			input = br.readLine();
			newCust[counter] = input;
			counter++;
			}while(counter < 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cust1 = new Customer(newCust[0]);
		if(newCust[1].equals("VL")||newCust[1].equals("ML")
				||newCust[1].equals("TV")||newCust[1].equals("PR")) {
			cust1.updtCustDB(newCust);
			backToMenu();
		}else {
			System.out.println("Wrong Membership Type. Please choose between: 'ML', 'VL', 'TV', 'PR'");
			updateCustomer();
		}
	}
	
	
	@Override
	public void registerRental() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		int counter = 0;
		String [] columns = {"Title", "Media", "customer"}; 
		try {
			do {
			System.out.println("Please enter the " + columns[counter]+ ": ");
			input = br.readLine();
			newRental[counter] = input;
			counter++;
			}while(counter < 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rental = new Rental();
		if(newRental[1].equals("Bluray")||newRental[1].equals("DVD")||newRental[1].equals("CD")) {
			rental.registerRental(newRental);
			backToMenu();
		}else {
			System.out.println("Media must be 'Bluray', 'DVD' or 'CD'. Try again...\n");
			registerRental();
		}
		
	}
	
	@Override
	public void registerReturn() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			System.out.println("Please enter the title to be returned: ");
			returnTitle = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rental = new Rental();
		rental.returnTitle(returnTitle);
		backToMenu();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new User();		
	}
}
