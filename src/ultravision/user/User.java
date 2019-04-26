package ultravision.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ultravision.interfaces.UserInterface;


public class User implements UserInterface{
	
	static String custName = null;
	private static String title;
	Rental rental = new Rental();
	
	
	public User() {
		homeScreen();
//		System.out.println(rental);
		
		
	}
	
	@Override
	public void homeScreen() {
		System.out.println("############ WELCOME TO ULTRAVISION ############");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;
		try {
//			System.out.println("Please enter customer name: ");
//			custName = br.readLine();
			
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
				System.out.println("Option 1");
			}else if(input.equals("2")){
				findTitle();
			}else if(input.equals("3")){
				System.out.println("Option 3");
			}else if(input.equals("4")){
				System.out.println("Option 4");
			}else if(input.equals("5")){
				System.out.println("Option 5");
			}else if(input.equals("6")){
				System.out.println("Option 6");
			}else if(input.equals("7")){
				System.out.println("Option 7");
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
		
	}
	
	@Override
	public void addTitle() {
		
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
//		Customer cust1 = new Customer(custName);
//		MembershipCard memberC = new MembershipCard();
//		
		Title titleName = new Title(title);
		System.out.println(titleName);
		
	}
}
