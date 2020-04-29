package main.java;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * @author patricia
 * @see https://github.com/PatriBetsabe/Sudoers-Academy
 */
public class SQLiteJDBC {
	private static final Logger LOGGER = Logger.getLogger("main.java.Login");
	
	public static void main( String args[] ) {
	     
	   }
	
	public Connection conectar() {
		Connection c = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:/home/patricia/eclipse-workspace/Sudoers-Academy/db.db");
	      } catch ( Exception e ) {
	    	  LOGGER.log(Level.SEVERE, e.getMessage());
	      }
	      return c;
		
	}

}
