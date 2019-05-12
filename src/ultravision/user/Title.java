package ultravision.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Title {
	
	String id, media, release, name, genre, director, band, concertTitle;
	
	
	public Title(String [] title) {
		
	}
	
	public void searchTitle(String[] title){
		{
			try{
				// Load the database driver
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://localhost:3306/ultraVision";
				String user = "root";
				String password = "ImpossibleToBreak2019!";
				String queryMovie = "SELECT * FROM movies where title="+"'"+ title[1]+ "'";
				String queryMusic = "SELECT * FROM musicCD where title="+"'"+ title[1]+ "'";
				String queryConcert = "SELECT * FROM concerts where title="+"'"+ title[1]+ "'";

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
				
				if(title[0].equals("1")) {
					while(rsMovie.next()) {
						//Populate variables with customer details from database
						id = rsMovie.getString("id");
						name =rsMovie.getString("title");
						release = rsMovie.getString("releaseYear");
						genre = rsMovie.getString("genre");
						director = rsMovie.getString("director");
						media = rsMovie.getString("media");
						
					}
					System.out.println("Title - "+ name + "\n"+ "Released - "
										+ release +"\n" + "Genre - " + genre+ "\n"
										+ "Director - " + director + "\n");
				}else if(title[0].equals("2")){
					while(rsMusic.next()) {
						//Populate variables with customer details from database
						id = rsMusic.getString("id");
						name =rsMusic.getString("title");
						band = rsMusic.getString("band");
						release = rsMusic.getString("releaseYear");
						
					}
					System.out.println("Title - "+ name + "\n"+ "Released - "
										+ release +"\n" + "Band - " + band + "\n");
				}else if(title[0].equals("3")) {
					while(rsConcert.next()) {
						//Populate variables with customer details from database
						id = rsConcert.getString("id");
						media =rsConcert.getString("media");
						release = rsConcert.getString("releaseYear");
						concertTitle = rsConcert.getString("title");
						band = rsConcert.getString("band");
					}
					System.out.println("Title - "+ concertTitle + "\n Band - " + band + "\n Released - "
										+ release + "\n Media - " + media + "\n");
				}else {
					System.out.println("Title not found. Try again...");
				}
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
				if(newTitle[4] != null) {
				      preparedStmt = conn.prepareStatement(queryMovie);
				      preparedStmt.setString (1, newTitle[0]);
				      preparedStmt.setString (2, newTitle[1]);
				      preparedStmt.setString (3, newTitle[2]);
				      preparedStmt.setString (4, newTitle[3]);
				      preparedStmt.setString (5, newTitle[4]);
				}else if(newTitle[3] != null){
					preparedStmt = conn.prepareStatement(queryConcert);
				      preparedStmt.setString (1, newTitle[0]);
				      preparedStmt.setString (2, newTitle[1]);
				      preparedStmt.setString (3, newTitle[2]);
				      preparedStmt.setString (4, newTitle[3]);
				}else {
					preparedStmt = conn.prepareStatement(queryMusic);
				      preparedStmt.setString (1, newTitle[0]);
				      preparedStmt.setString (2, newTitle[1]);
				      preparedStmt.setString (3, newTitle[2]);
				      
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
