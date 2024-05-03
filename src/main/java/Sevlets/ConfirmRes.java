package Sevlets;

import DAO.ReservationDAO;
import MYSQLIMP.ReservationDAOImpl;
import Modals.Reservation;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/confirm-reservation")
public class ConfirmRes extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationDAO reservationDAO=new ReservationDAOImpl();
        String viewer= (String) req.getSession().getAttribute("username");
        String title = req.getParameter("title");
        Integer price= Integer.valueOf(req.getParameter("amount"));
        Date date = Date.valueOf(req.getParameter("date"));
        String seats = req.getParameter("seat");

        req.setAttribute("title", title);
        req.setAttribute("price", price);
        req.setAttribute("date", date);
        req.setAttribute("seats", seats);
        req.setAttribute("viewer", viewer);
        Reservation reservation=new Reservation(viewer,title ,date,price,seats);
        try {
            reservationDAO.insertReservation(reservation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/ConfirmReservation.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}