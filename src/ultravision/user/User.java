package ultravision.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ultravision.interfaces.UserInterface;


public class User implements UserInterface{
	
	static String custName = null;
	private static String title;
	Rental rental;
	Customer cust1;
	Title titleName;
	String[] newCust = new String[2];
	String[] newTitle = new String[5];
	
	public User() {
		homeScreen();
		titleName = new Title(title);
//		cust1 = new Customer(custName);
		titleName.addTitleDB(newTitle);
	
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
		
	}
	
	@Override
	public void findTitle() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			System.out.println("Please enter the title: ");
			title = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		cust1.addCustDB(newCust);
		
	}
	
	@Override
	public void addTitle() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input = "";
		int counter = 0;
		String [] columns = {}; 
		String[] moviesColumns = {"Media", "Year of Release", "Title", "Genre", "Director"};
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
		
		
	}
	
	@Override
	public void updateCustomer() {
		
	}
	
	@Override
	public void registerRental() {
		
	}
	
	@Override
	public void registerReturn() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new User();		
	}
}
