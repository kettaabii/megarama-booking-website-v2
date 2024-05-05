package Sevlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MYSQLIMP.MoviesDAOImpl;

@WebServlet("/BookMovie")

public class BookMovieServlet extends HttpServlet {
private final MoviesDAOImpl moviesDAO=new MoviesDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests
        doGet(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the movie ID from the request parameter

        int movieId = Integer.parseInt(request.getParameter("id"));
        try {
           //Movie movie=moviesDAO.getMovieById(movieId);
            request.setAttribute("Movie", moviesDAO.getMovieById(movieId));

            System.out.println(moviesDAO.getMovieById(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // Forward the request to the JSP for displaying movie details and booking form
        request.getRequestDispatcher("/BookMovie.jsp").forward(request, response);
    }
}
