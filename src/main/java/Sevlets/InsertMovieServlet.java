package Sevlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MovieDAO;
import MYSQLIMP.MoviesDAOImpl;
import Modals.Movie;


@WebServlet("/InsertMovieServlet")
public class InsertMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO film = new MoviesDAOImpl();
		String Title = request.getParameter("Title");
		String Dsecription = request.getParameter("Description");
		String ReleaseDateString = request.getParameter("ReleaseDate");
		int Duration = Integer.parseInt(request.getParameter("Duration"));
		String Genre = request.getParameter("Genre");
		String Director = request.getParameter("Director");
		String Cover = request.getParameter("Cover");
		String MegaCover = request.getParameter("MegaCover");
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
				System.out.println( ReleaseDateString +":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


	            Movie movie = new Movie(0,Title, Dsecription,ReleaseDateString, Duration, Genre, Director, Cover,MegaCover);
				film.insertMovie(movie);


	            response.sendRedirect(request.getContextPath() + "/affcihermovies");
	        } catch (ParseException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	

}
