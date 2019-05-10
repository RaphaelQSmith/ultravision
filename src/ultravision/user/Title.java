package ultravision.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Title {
	
	String id, media, release, name, genre, director, band;
	
	
	public Title(String title) {
		searchTitle(title);
	}
	
	public void searchTitle(String title){
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String queryMovie = "SELECT * FROM movies where title="+"'"+ title+ "'";
				String queryMusic = "SELECT * FROM musicCD where title="+"'"+ title+ "'";
				String queryConcert = "SELECT * FROM concerts where title="+"'"+ title+ "'";

				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				// Get a statement from the connection
				Statement stmt = conn.createStatement() ;
				Statement stmt2 = conn.createStatement() ;
				Statement stmt3 = conn.createStatement() ;

				// Execute the query
				ResultSet rsMovie = stmt.executeQuery(queryMovie) ;
				ResultSet rsMusic = stmt2.executeQuery(queryMusic) ;
				ResultSet rsConcert = stmt3.executeQuery(queryConcert) ;
				
				if(rsMovie != null) {
					while(rsMovie.next()) {
						//Populate variables with customer details from database
						id = rsMovie.getString("id");
						name =rsMovie.getString("title");
						release = rsMovie.getString("releaseYear");
						genre = rsMovie.getString("genre");
						director = rsMovie.getString("director");
						media = rsMovie.getString("media");

					}
					
				}else if(rsMusic != null){
					while(rsMusic.next()) {
						//Populate variables with customer details from database
						id = rsMusic.getString("id");
						name =rsMusic.getString("title");
						band = rsMusic.getString("band");
						release = rsMusic.getString("releaseYear");

					}
					
				}else if(rsConcert != null) {
					while(rsConcert.next()) {
						//Populate variables with customer details from database
						id = rsConcert.getString("id");
						name =rsConcert.getString("fullname");
						band = rsConcert.getString("type");
						release = rsConcert.getString("loyaltypoints");
						media = rsConcert.getString("media");

					}
					
				}else {
					System.out.println("Title not found. Try again...");
				}
				
				// Loop through the result set
				
				
//				System.out.println( id + "\n" + name+ 
//				"\t" + "\n" + type+ "\n" + loyaltypoints + "\n"+ balance);
				rsMovie.close() ;
				rsConcert.close() ;
				rsMusic.close() ;
				stmt.close() ;
				stmt2.close() ;
				stmt3.close() ;
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
	
	public void addTitleDB(String[] newTitle) {
		{
			
			
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String queryMusic = "INSERT INTO musicCD (releaseYear, title, band)"
						+ " values(?,?,?)";
				String queryConcert = "INSERT INTO concerts (media, releaseYear, title, band)"
						+ " values(?,?,?,?)";
				String queryMovie = "INSERT INTO movies (media, releaseYear, title, genre, director)"
						+ " values(?,?,?,?,?)";
				
				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;
				
				PreparedStatement preparedStmt;
				if(newTitle.length == 3) {
					preparedStmt = conn.prepareStatement(queryMusic);
				      preparedStmt.setString (1, newTitle[0]);
				      preparedStmt.setString (2, newTitle[1]);
				      preparedStmt.setString (3, newTitle[2]);
				}else if(newTitle.length == 4){
					preparedStmt = conn.prepareStatement(queryConcert);
				      preparedStmt.setString (1, newTitle[0]);
				      preparedStmt.setString (2, newTitle[1]);
				      preparedStmt.setString (3, newTitle[2]);
				      preparedStmt.setString (4, newTitle[3]);
				}else {
					preparedStmt = conn.prepareStatement(queryMovie);
				      preparedStmt.setString (1, newTitle[0]);
				      preparedStmt.setString (2, newTitle[1]);
				      preparedStmt.setString (3, newTitle[2]);
				      preparedStmt.setString (4, newTitle[3]);
				      preparedStmt.setString (5, newTitle[4]);
				}

				// Execute the query
				preparedStmt.execute() ;
				
				//Close the connection
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
		return "Title - "+ name + "\n"+ "Released - "+ release +"\n" + "Genre - " + genre+ "\n"+ "Director - " + director + "\n";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

}
