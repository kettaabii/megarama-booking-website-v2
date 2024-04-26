package Sevlets;

import MYSQLIMP.MoviesDAOImpl;

import java.io.*;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BookMovie")
public class Bookmovie extends HttpServlet {
    private String message;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filmId = req.getParameter("FilmId");
        super.doPost(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response, int filmId) throws IOException {
        MoviesDAOImpl film = new MoviesDAOImpl();
        try {
            request.setAttribute("filmtobook", film.getMovieById(filmId));
            System.out.println(film.getMovieById(filmId));
            response.sendRedirect("Said.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}