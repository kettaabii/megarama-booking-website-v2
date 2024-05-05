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
import MYSQLIMP.MoviesDAOImpl;
import Modals.Movie;
import MYSQLIMP.Connectiondb;


/**
 * Servlet implementation class MovieServletsearch
 */
@WebServlet("/MovieServletsearch")
public class MovieServletsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MoviesDAOImpl film = new MoviesDAOImpl();
		String title = request.getParameter("title");
		    if (title != null && !title.isEmpty()) {
		        try {
		            List<Movie> movies = film.searchMoviesByTitle(title);
		            request.setAttribute("movies", movies);
		        } catch (SQLException e) {
		            request.setAttribute("errorMessage", "Une erreur s'est produite lors de la recherche de films.");
		            request.getRequestDispatcher("error.jsp").forward(request, response);
		            return;
		        }
		    }
		    request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
