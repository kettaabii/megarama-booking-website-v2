package Sevlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MovieDAO;
import DAO.UserDAO;
import MYSQLIMP.Connectiondb;
import MYSQLIMP.MoviesDAOImpl;
import MYSQLIMP.UserDAOImpl;
import Modals.Movie;
import Modals.User;


@WebServlet("/lisetesusersservlets")
public class lisetesusersservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	 private UserDAO userDAO;

	    public void init() throws ServletException {
	        super.init();
	        Connection connection = null;
	        try {
	            connection = Connectiondb.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle SQLException appropriately
	        }
	        userDAO = new UserDAOImpl(connection);
	    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
       
     
        try {
            
        	 List<User> users = userDAO.getAllUsers(); 
             request.setAttribute("users", users); 
    
            request.getRequestDispatcher("lisetsusers.jsp").forward(request, response);
        } catch (SQLException e) {
        
            e.printStackTrace(); 
            response.getWriter().println("Erreur lors de la récupération des films.");
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
