package ultravision.interfaces;

public interface UserInterface {

	//Display Main Menu
	public void homeScreen();

	//Ask for customer name and check Database. Return full details.
	public void findCustomer();

	//Ask for title and check Database. Return movie, concert or music CD full details.
	public void findTitle();

	//Ask for customer full details and creates new row at database.
	public void addCustomer();

	//Ask for title full details and creates new row at database.
	public void addTitle();

	//Ask for customer fullname and new Membership type. Updates customer details.
	public void updateCustomer();

	//
	public void registerRental();

	public void registerReturn();

}