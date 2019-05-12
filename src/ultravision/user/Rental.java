package ultravision.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rental {
	
	String id, title, type, customer, date, query;
	
	public Rental(){
		
	}
	
	public void registerRental(String[] newRental) {
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String query = "INSERT INTO rentals (title, type, customer, date)"
						+ " values(?,?,?,?)";

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				LocalDate localDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String formattedString = localDate.format(formatter);
				System.out.println(formattedString);
				
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, newRental[0]);
			      preparedStmt.setString (2, newRental[1]);
			      preparedStmt.setString (3, newRental[2]);
			      preparedStmt.setString (4, formattedString);
			      
				// Execute the query
			      preparedStmt.execute() ;
				
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
	public void returnTitle(String title) {
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String query = "UPDATE rentals SET returnDate=? WHERE title=?";

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				LocalDate localDate = LocalDate.now();
				DateTimeFormatter dateAsString = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String currentDate = localDate.format(dateAsString);
				System.out.println(currentDate);
				
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString (1, currentDate);
			    preparedStmt.setString (2, title);
			      
				// Execute the query
			    preparedStmt.execute() ;
				
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
		return 
				"Rental [id=" + id + ", title=" + title + ", type=" + type + ", customer=" + customer + ", date=" + date
				+ "]";
	}
	
	

}
