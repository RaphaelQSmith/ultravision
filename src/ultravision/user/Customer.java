package ultravision.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

	private String id, name, type, loyaltypoints, balance;
	
	
	public Customer(String fullname) { //Constructor
		findCust(fullname);
		
	}
	

	public void findCust(String fullname) {
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
	
	public void addCustDB(String[] newCust) {
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String query = "INSERT INTO customers (fullname, type)"
						+ " values(?,?)";

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, newCust[0]);
			      preparedStmt.setString (2, newCust[1]);

				// Execute the query
				preparedStmt.execute() ;
				
				//close connection
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
	
	public void updtCustDB(String[] upCust) {
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String query = "UPDATE customers SET type=? WHERE fullname=?";

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				// Populate query with new info
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, upCust[1]);
			      preparedStmt.setString (2, upCust[0]);

				// Execute the query with prepared statement
				preparedStmt.execute();
				
				//close connection
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
	
	@Override
	public String toString() {
		return name + "\n" + " Membership status > " + type + 
				  "\n Loyalty points > " + loyaltypoints + "\n Balance > "+ balance;
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
