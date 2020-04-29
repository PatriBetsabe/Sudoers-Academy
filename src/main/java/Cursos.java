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

/**
 * Servlet implementation class Cursos
 */
@WebServlet("/Cursos")
public class Cursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("main.java.Login");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cursos() {
        super();
    }

	/** This method will be called when a get request is made, 
	 *  in this case it will be for the comment form
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nicknameComment");
		String comment = request.getParameter("comment");
		
		LOGGER.log(Level.INFO, nickname + " " + comment );
	}

	/** This method will be called when a post request is made, 
	 *  in this case it will be for the purchase form
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] products = request.getParameterValues("image[]");
		
		String productsStr = "";
		for (int i=0; i<products.length; i++) {
			productsStr+= products[i] + ",";
		}
		String payment = request.getParameter("payment");
		String nickname = request.getParameter("nickname");
		String grade = request.getParameter("grade");
		
		LOGGER.log(Level.INFO, productsStr + " " + payment + " " + nickname + " " + grade);
	}

	/**
	 * This method checks that the user exists
	 * @param nickname
	 * @return
	 * @throws SQLException
	 */
	public boolean comprovaNickname(String nickname) throws SQLException, NullPointerException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			SQLiteJDBC db = new SQLiteJDBC();
			con = db.conectar();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * "
					+ "FROM USER "
					+ "WHERE NICK LIKE '"+ nickname + "'");
			
			while (rs.next()) {
				String nick = rs.getString("NICK");
				
				if (nick != null) {
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
}
