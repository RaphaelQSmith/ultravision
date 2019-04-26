package ultravision.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ultravision.interfaces.UserInterface;

public class User implements UserInterface{
	
	static String custName = null;
	
	public User() {
		homeScreen();
		
	}
	
	@Override
	public void homeScreen() {
		System.out.println("############ WELCOME TO ULTRAVISION ############");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		try {
			System.out.println("Please enter customer name: ");
			custName = br.readLine();
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
		Customer cust1 = new Customer(custName);
		MembershipCard memberC = new MembershipCard();
	
		System.out.println("Membership number: " + cust1.getId());
		System.out.println("Loyalty Points: " + cust1.getLoyaltypoints());
		Double valueConvert = Double.parseDouble(cust1.getBalance());
		System.out.println(String.format( "Balance: €"+ "%.2f" , valueConvert));
		
		
		
	}
}
