package main.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Given a email make sure what that is correct
     * @param email
     * @return boolean
     */
    public boolean existeixEmail(String email) {
    	//Comprueba que el email existe en la base de datso
    	Connection con = null;
    	Statement stmt = null;
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		
    		stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * "
    				+ "FROM USER "
    				+ "WHERE EMAIL LIKE '" + email + "'");
    		
    		while (rs.next()) {
    			String mail = rs.getString("EMAIL");
    			
    			if (mail.equals(email)) {
    				System.out.println("Email existeix.");
    				return false;
    			}
    		}
    		rs.close();
    		stmt.close();
    		con.close();
    	} catch (Exception e) {
    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	    System.exit(0);
    	}
    	//System.out.println("Operation done successfully");
    	return true;
    }
    
    public boolean coincideixPassword(String email, String password) {
    	//Comprueba que el password sea del usuario
    	Connection con = null;
    	Statement stmt = null;
    	
    	try {
    		SQLiteJDBC db = new SQLiteJDBC();
    		con = db.conectar();
    		
    		stmt = con.createStatement();
    		
    		ResultSet rs = stmt.executeQuery("SELECT * "
    				+ "FROM USER "
    				+ "WHERE EMAIL = '"+ email
    				+ "' AND PASS = '" + password + "'");
    		
    		while (rs.next()) {
    			String mail = rs.getString("EMAIL");
    			
    			if (mail.equals(null)) {
    				System.out.println("Email no existeix.");
    				return false;
    			}
    		}
    		rs.close();
    		stmt.close();
    		con.close();
    	} catch (Exception e) {
    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	    System.exit(0);
    	}
    	//System.out.println("Operation done successfully");
    	return true;
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		/*
		System.out.println("\nUser:" + email);
		System.out.println("Password: "  + password);
		
		if("patri@hi.com".equals(email) && "pass".equals(password)) {
			response(response, "login ok");
		} else {
			response(response, "Invalid login");
		} */
		
		boolean matchPassword = false;
		
		PrintWriter out = response.getWriter();
		
		boolean existeUser = this.existeixEmail(email);
		
		if (!existeUser) {
			System.out.println("El email no existe");
		} else {
			if (this.coincideixPassword(email, password)) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Contraseña inválida");
			}
		}
		
	}
	
	private void response(HttpServletResponse response, String msg) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
