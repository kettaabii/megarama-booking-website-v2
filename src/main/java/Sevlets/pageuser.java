package Sevlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MYSQLIMP.MoviesDAOImpl;
import MYSQLIMP.ReservationDAOImpl;
import Modals.Reservation;

/**
 * Servlet implementation class pageuser
 */
@WebServlet("/pageuser")
public class pageuser extends HttpServlet {





    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ReservationDAOImpl reservation = new ReservationDAOImpl();
        MoviesDAOImpl film = new MoviesDAOImpl();
        try {
        	
            request.setAttribute("filmlist", film.getAllMovies());
            System.out.println(film.getAllMovies());
            List<Reservation> reservations  = reservation.getAllReservations();
      	    request.setAttribute("reservations", reservations);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    request.getRequestDispatcher("/cllogin.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
