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
import Modals.Movie;
import MYSQLIMP.Connectiondb;
import MYSQLIMP.MoviesDAOImpl;

/**
 * Servlet implementation class affcihermovies
 */
@WebServlet("/affcihermovies")
public class affcihermovies extends HttpServlet {
    private static final long serialVersionUID = 1L;




    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		MoviesDAOImpl film = new MoviesDAOImpl();
		request.setAttribute("filmlist", film.getAllMovies());
            
    
            request.getRequestDispatcher("afficheMovies.jsp").forward(request, response);

        

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
		MoviesDAOImpl film = new MoviesDAOImpl();
    	    if (request.getParameter("filmId") != null) {
    	        int filmId = Integer.parseInt(request.getParameter("filmId"));
    	        try {
    	            film.deleteMovie(filmId);
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	            response.getWriter().println("Erreur lors de la suppression du film.");
    	        }
    	    }

    	    if (request.getParameter("updateFilmId") != null) {
    	        int filmId = Integer.parseInt(request.getParameter("updateFilmId"));
    	        try {
    	            Movie movie = film.getMovieById(filmId);

    	            request.setAttribute("movie", movie);

    	            request.getRequestDispatcher("afficheMovies.jsp").forward(request, response);

    	        } catch (SQLException e) {

    	            e.printStackTrace();
    	            response.getWriter().println("Erreur lors de la récupération des informations du film.");
    	        }
    	    }



    	}
}

   

