package main.java;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class Registro
 * @author patricia
 * @see https://github.com/PatriBetsabe/Sudoers-Academy
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("main.java.Login");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
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
    
    /**
     * This method checks that the user exists
     * @param nickname
     * @param email
     * @return
     * @throws SQLException
     */
    public boolean comprovaNicknameAndEmail(String nickname, String email) throws SQLException, NullPointerException {
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		
    		stmt = con.createStatement();
    		rs = stmt.executeQuery("SELECT * "
    				+ "FROM USER "
    				+ "WHERE NICK LIKE '"+ nickname
    				+ "' AND EMAIL LIKE '" + email + "'");
    		
    		while (rs.next()) {
    			String nick = rs.getString("NICK");
    			String mail = rs.getString("EMAIL");
    			
    			if (nick != null || mail != null) {
    				LOGGER.log(Level.INFO, "Nickname o email ja existeix.");
    				return true;
    			}
    		}
    		stmt.close();
    	} catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	} finally {
    		rs.close();
    		con.close();
    	}
    	return false;
    }
    
    /**
     * Validate email with regular expressions.
     * @param email
     * @return true if it matches
     */
    public boolean validaEmail(String email) {
    	boolean allValid = false;
			String regexEmail = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+"; 
			Pattern patternE = Pattern.compile(regexEmail);
			Matcher matcherEmail = patternE.matcher(email);

			if (matcherEmail.matches()) {
				allValid= true;
			}
		return allValid;
    }
    
    /**
     * Validate nickname with regular expressions.
     * @param nickname
     * @return true if it matches
     */
    public boolean validaNickName(String nickname) {
    	String regexNickname = "^[a-z0-9_-]{3,15}$"; 
		Pattern pattern = Pattern.compile(regexNickname);
		Matcher matcherNickname = pattern.matcher(nickname);

			if (matcherNickname.matches()) {
				return true;
			}
		return false;
    }

    /**
     * Validate password with regular expressions.
     * @param password
     * @return true if it matches
     */
    public boolean validaPassword(String password) {
	    	String regexPassword = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
			Pattern pattern = Pattern.compile(regexPassword);
			Matcher matcherPassword = pattern.matcher(password);

			if (matcherPassword.matches()) {
				return  true;
			}
		return false;
    }
    
    /**
     * Validate all String parameters with regular expressions.
     * @param request
     * @param response
     * @param nickname
     * @param email
     * @param password
     * @return true if it matches
     * @throws ServletException
     * @throws IOException
     */
    public boolean validaRegex(HttpServletRequest request, HttpServletResponse response, String nickname, String email, String password) throws ServletException, IOException {  
		if (!this.validaEmail(email) && !this.validaNickName(nickname) && !this.validaPassword(password)) {
			getServletContext().getRequestDispatcher("/LoginNoOk.html").forward(request, response);
		}
		return true;
    }
    
    /**
     * Insert a new user into the database
     * @param nickname
     * @param email
     * @param password
     * @throws SQLException 
     */
    public void insertaUser(String nickname, String email, String password) throws SQLException, NullPointerException {
    	Connection con = null;
    	Statement stmt = null;
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		con.setAutoCommit(false);
    		stmt = con.createStatement();
    		
    		String sql = "INSERT INTO USER (NICK, PASS, EMAIL) " +
                    "VALUES ('" + nickname+ "', '" + password+ "', '" + email+ "');"; 
    		
    		stmt.executeUpdate(sql);
    		con.commit();
    		
    	} catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	} finally {
    		stmt.close();
    		con.close();
    	}
    	LOGGER.log(Level.INFO, "User inserted successfully");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		try {
			this.createTableUser();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean allValid = this.validaRegex(request, response, nickname, email, password);
		
		if (allValid) {
			boolean existeUser = true;
			try {
				existeUser = this.comprovaNicknameAndEmail(nickname, email);
			} catch (SQLException e) {
				LOGGER.log(Level.SEVERE, e.getMessage());
			}
			if (!existeUser) {
				try {
					this.insertaUser(nickname, email, password);
					response.sendRedirect("RegistroOk.html");
				} catch (SQLException e) {
					LOGGER.log(Level.SEVERE, e.getMessage());
				}
			} else {
				response.sendRedirect("LoginNoOk.html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
