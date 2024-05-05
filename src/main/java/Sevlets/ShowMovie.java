package Sevlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MYSQLIMP.MoviesDAOImpl;

@WebServlet(name = "ShowMovieServlet", value = "/ShowMovie-servlet")
public class ShowMovie extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MoviesDAOImpl film = new MoviesDAOImpl();
        try {
            request.setAttribute("filmlist", film.getAllMovies());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    request.getRequestDispatcher("/cllogin.jsp").forward(request,response);
    }
}