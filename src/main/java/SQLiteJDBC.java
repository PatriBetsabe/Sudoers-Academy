package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Properties;

/**
 * @author patricia
 * @see https://github.com/PatriBetsabe/Sudoers-Academy
 */
public class SQLiteJDBC {
	private static final Logger LOGGER = Logger.getLogger("main.java.SQLiteJDBC");
	
	public static void main( String args[] ) throws SQLException {
		SQLiteJDBC db = new SQLiteJDBC();
    	db.createCommentTable();
	   }
	
	public Connection conectar() throws FileNotFoundException, IOException {
		Connection c = null;
		File archivo = new File("/home/patricia/eclipse-workspace/Sudoers-Academy/src/main/resources/config.properties");
		
		try (InputStream inputStream = new FileInputStream(archivo)) {
			Properties prop = new Properties();
            prop.load(inputStream);
            
            String uri = prop.getProperty("URI");
            
            Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection(uri);         
	      } catch ( Exception e ) {
	    	  LOGGER.log(Level.SEVERE, e.getMessage());
	      }
	      return c;
		
	}
	
	/**
     * This method creates the PURCHASE table for the case that it does not exist.
     * @throws SQLException
     */
	public void createPurchase() throws SQLException {
		Connection con = null;
        Statement stmt = null;
        
		try {
			con = this.conectar();
			stmt = con.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS PURCHASE (" +
       			 	"REF INTEGER PRIMARY KEY AUTOINCREMENT, " +
       			    "NICK  VARCHAR(20) NOT NULL, " +
	                "PRODUCTS VARCHAR(500), " + 
	                "PAYMENT VARCHAR(25), " + 
	                "GRADE INTEGER, " + 
	                "AMOUNT REAL DEFAULT 0, " + 
	                "FOREIGN KEY (NICK) REFERENCES USER (NICK)" +
	                ")";
       
       stmt.executeUpdate(sql);
		} catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
        	stmt.close();
            con.close();
        }
        LOGGER.log(Level.INFO, "Table PURCHASE created successfully");
    }
	
	/**
     * This method creates the COMMENT table for the case that it does not exist.
     * @throws SQLException
     */
	public void createCommentTable() throws SQLException {
		Connection con = null;
        Statement stmt = null;
        
		try {
			con = this.conectar();
			stmt = con.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS COMMENT (" +
       			 	"REF INTEGER PRIMARY KEY AUTOINCREMENT, " +
       			    "NICK  VARCHAR(20) NOT NULL, " +
	                "COMMENTS VARCHAR(500), " + 
	                "FOREIGN KEY (NICK) REFERENCES USER (NICK)" +
	                ")";
       
       stmt.executeUpdate(sql);
		} catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
        	stmt.close();
            con.close();
        }
        LOGGER.log(Level.INFO, "Table COMMENT created successfully");
    }
	
	/**
     * This method creates the USER table for the case that it does not exist.
     * @throws SQLException
     */
    public void createTableUser() throws SQLException, NullPointerException {
    	Connection con = null;
        Statement stmt = null;
        try {
        	SQLiteJDBC db = new SQLiteJDBC();
        	con = db.conectar();
        	stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USER (" +
            			 "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "NICK  VARCHAR(20) NOT NULL," +
                         "PASS VARCHAR(20), " + 
                         "EMAIL VARCHAR(20)" + 
                         ")";
            
            stmt.executeUpdate(sql);
        } catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
        	stmt.close();
            con.close();
        }
        LOGGER.log(Level.INFO, "Table created successfully");
    }

}
