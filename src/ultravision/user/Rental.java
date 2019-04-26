package ultravision.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Rental {
	
	String id, title, type, customer, date, query;
	
	public Rental(){
		dbRequest();
		
	}
	
	private void dbRequest(String a) {
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				query = a;

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				// Get a statement from the connection
				Statement stmt = conn.createStatement() ;

				// Execute the query
				ResultSet rs = stmt.executeQuery(query) ;
				
				
				// Loop through the result set
				while(rs.next()) {
					//Populate variables with customer details from database
					id = rs.getString("rentalid");
					title =rs.getString("title");
					type = rs.getString("type");
					customer = rs.getString("customer");
					date = rs.getString("date");

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
	public void rentTitle() {
		
	}

	@Override
	public String toString() {
		return 
				"Rental [id=" + id + ", title=" + title + ", type=" + type + ", customer=" + customer + ", date=" + date
				+ "]";
	}
	
	

}
