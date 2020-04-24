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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void createTableUser() throws SQLException {
    	// Este metodo crea la tabla USER para el caso que esta no exista
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
            
            //String sql = "DROP TABLE IF EXISTS USER";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch (Exception e){
        	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");   	
    }
    
    public boolean comprovaNicknameAndEmail(String nickname, String email) throws SQLException {
    	//Este metodo comprueba que el usuari exista
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
    			
    			if (!nick.equals(null) || !mail.equals(null)) {
    				System.out.println("Nickname o email ja existeix.");
    				return true;
    			}
    		}

    	} catch (Exception e) {
    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	    System.exit(0);
    	} finally {
    		rs.close();
    		stmt.close();
    		con.close();
    	}
    	//System.out.println("Operation done successfully");
    	return false;
    }
    
    
    public static boolean validaEmail(String email) {
    	boolean allValid = false;
    	// Valida email
			String regex_email = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+"; 
			Pattern pattern_e = Pattern.compile(regex_email);
			Matcher matcher_email = pattern_e.matcher(email);

			if (matcher_email.matches()) {
				allValid= true;
			}
		return allValid;
    }
    
    public static boolean validaNickName(String nickname) {
    	// Valida nickname
    	String regex_nickname = "^[a-z0-9_-]{3,15}$"; 
		Pattern pattern_n = Pattern.compile(regex_nickname);
		Matcher matcher_nickname = pattern_n.matcher(nickname);

			if (matcher_nickname.matches()) {
				return true;
			}
		return false;
    }

    public static boolean validaPassword(String password) {
    	// Valida password
	    	String regex_password = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
			Pattern pattern_p = Pattern.compile(regex_password);
			Matcher matcher_password = pattern_p.matcher(password);

			if (matcher_password.matches()) {
				return  true;
			}
		return false;
    }
    
    public boolean validaRegex(HttpServletRequest request, HttpServletResponse response, String nickname, String email, String password) throws ServletException, IOException {
    	// Este metodo comprueba que los datos introducidos
    	// sean válidos con Regex.
  
		if (!this.validaEmail(email) && !this.validaNickName(nickname) && !this.validaPassword(password)) {
			getServletContext().getRequestDispatcher("/LoginNoOk.html").forward(request, response);
		}
		return true;
    }
    
    public void insertaUser(String nickname, String email, String password) {
    	//Inserta un nuevo usuario en base de datos
    	
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
   
    		stmt.close();
    		con.commit();
    		con.close();
    	} catch (Exception e) {
    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	    System.exit(0);
    	}
    	System.out.println("User inserted successfully");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		try {
			this.createTableUser();
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	    System.exit(0);
		}
		
		// Valida nickname
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean allValid = this.validaRegex(request, response, nickname, email, password);
		
		if (allValid) {
			boolean existeUser = true;
			try {
				existeUser = this.comprovaNicknameAndEmail(nickname, email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!existeUser) {
				this.insertaUser(nickname, email, password);
				//getServletContext().getRequestDispatcher("/RegistroUsuarios.html").include(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
