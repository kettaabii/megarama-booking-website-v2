package Sevlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MovieDAO;
import MYSQLIMP.Connectiondb;
import MYSQLIMP.MoviesDAOImpl;
import Modals.Movie;

@WebServlet("/updateservlet")

public class UpdateServlet extends HttpServlet {
MovieDAO movieDAO=new MoviesDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int filmId = Integer.parseInt(request.getParameter("filmId"));
        String Title = request.getParameter("Title");
        String Dsecription = request.getParameter("Description");
        Date ReleaseDate=Date.valueOf( request.getParameter("ReleaseDate"));
        int Duration = Integer.parseInt(request.getParameter("Duration"));
        String Genre = request.getParameter("Genre");
        String Director = request.getParameter("Director");
        String Cover = request.getParameter("Cover");
        String MegaCover = request.getParameter("MegaCover");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println( ReleaseDate +":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


           Movie movie=new Movie(filmId,Title,Dsecription,ReleaseDate,Duration,Genre,Director,Cover,MegaCover);
            movieDAO.updateMovie(movie);


            response.sendRedirect(request.getContextPath() + "/affcihermovies");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }}