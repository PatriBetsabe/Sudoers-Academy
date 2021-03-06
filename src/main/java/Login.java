package main.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 * @author patricia
 * @see https://github.com/PatriBetsabe/Sudoers-Academy
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("main.java.Login");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }
    
    /**
     * Given a email look in the database if the email exists.
     * @param email
     * @return true if exists email.
     * @throws SQLException 
     */
    public boolean existeixEmail(String email) throws SQLException {
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		
    		stmt = con.createStatement();
    		rs = stmt.executeQuery("SELECT * "
    				+ "FROM USER "
    				+ "WHERE EMAIL LIKE '" + email + "'");
    		
    		while (rs.next()) {
    			String mail = rs.getString("EMAIL");
    			
    			if (mail.equals(email)) {
    				LOGGER.log(Level.INFO, "Email existeix.");
    				return true;
    			}
    		}
    	} catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	    System.exit(0);
    	} finally {
    		rs.close();
    		stmt.close();
    		con.close();
    	}
    	return false;
    }
    
    /**
     * Given a User and password check that the password belongs to this user.
     * @param email
     * @param password
     * @return
     * @throws SQLException 
     */
    public boolean coincideixPassword(String email, String password) throws SQLException, NullPointerException {
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	String pass = null;
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		stmt = con.createStatement();
    		
    		rs = stmt.executeQuery("SELECT * "
    				+ "FROM USER "
    				+ "WHERE EMAIL = '"+ email
    				+ "' AND PASS = '" + password + "'");
    		
    		while (rs.next()) {
    			pass = rs.getString("PASS");

    		}
            
        } catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	    System.exit(0);
    	    
    	} finally {
    		rs.close();
    		stmt.close();
    		con.close();
    	}
    	
    	return pass.equals(password);
    }
    
    /**
     * Given a email, find a user and return it.
     * @param email
     * @return String
     * @throws SQLException 
     */
    public String getUser(String email) throws SQLException, NullPointerException {
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	String user = "";
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		stmt = con.createStatement();
    		
    		rs = stmt.executeQuery("SELECT * "
    				+ "FROM USER "
    				+ "WHERE EMAIL = '"+ email + "'");
    		
    		while (rs.next()) {
    			user = rs.getString("NICK");
    		}
            
        } catch (Exception e) {
    		LOGGER.log(Level.SEVERE, e.getMessage());
    	    System.exit(0);
    	    
    	} finally {
    		rs.close();
    		stmt.close();
    		con.close();
    	}
    	
    	return user;
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean existeUser = false;
		try {
			existeUser = this.existeixEmail(email);
		} catch (SQLException e) {
			response.sendRedirect("LoginNoOk.jsp");
		}
		
		if (!existeUser) {
			LOGGER.log(Level.INFO, "El email no existe.");
			response.sendRedirect("LoginNoOk.jsp");
		} else {
			try {
				if (this.coincideixPassword(email, password)) {
					String user = this.getUser(email);
					LOGGER.log(Level.INFO, "Login successful!");
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(300); // 300 seconds
					response.sendRedirect("Home.jsp");
				} else {
					LOGGER.log(Level.INFO, "Contraseña inválida");
					response.sendRedirect("LoginNoOk.jsp");
				}
			} catch (NullPointerException | SQLException | IOException e) {
				response.sendRedirect("LoginNoOk.jsp");
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
