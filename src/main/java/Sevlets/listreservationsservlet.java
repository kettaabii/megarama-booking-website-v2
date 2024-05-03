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

import DAO.ReservationDAO;
import MYSQLIMP.Connectiondb;
import MYSQLIMP.MoviesDAOImpl;
import MYSQLIMP.ReservationDAOImpl;
import Modals.Reservation;


@WebServlet("/listreservationsservlet")
public class listreservationsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationDAO res = new ReservationDAOImpl();

		try {
			request.setAttribute("Reservationlist", res.getAllReservations());
			System.out.println(res.getAllReservations()+"LLLLMMMMMMKKK");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/listreservations.jsp").forward(request,response);

      
        }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
