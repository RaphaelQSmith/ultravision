package ultravision.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
	
	
	private String id, name, type, loyaltypoints, balance;
	
	
	public Customer(String fullname) { //Constructor
		dbRequest(fullname);
		
	}
	

	private void dbRequest(String fullname) {
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String query = "SELECT * FROM customers where fullname="+"'"+ fullname+ "'";

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				// Get a statement from the connection
				Statement stmt = conn.createStatement() ;

				// Execute the query
				ResultSet rs = stmt.executeQuery(query) ;
				
				
				// Loop through the result set
				while(rs.next()) {
					//Populate variables with customer details from database
					id = rs.getString("idcustomer");
					name =rs.getString("fullname");
					type = rs.getString("type");
					loyaltypoints = rs.getString("loyaltypoints");
					balance = rs.getString("balance");

				}
				
//				System.out.println( id + "\n" + name+ 
//				"\t" + "\n" + type+ "\n" + loyaltypoints + "\n"+ balance);
				rs.close() ;
				stmt.close() ;
				conn.close() ;
			}
			catch( SQLException se ){
				System.out.println( "SQL Exception:" ) ;

				// Loop through the SQL Exceptions
				while( se != null ){
					System.out.println( "State  : " + se.getSQLState()  ) ;
					System.out.println( "Message: " + se.getMessage()   ) ;
					System.out.println( "Error  : " + se.getErrorCode() ) ;

					se = se.getNextException() ;
				}
			}
			catch( Exception e ){
				System.out.println( e ) ;
			}
		}
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLoyaltypoints() {
		return loyaltypoints;
	}

	public void setLoyaltypoints(String loyaltypoints) {
		this.loyaltypoints = loyaltypoints;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
}
