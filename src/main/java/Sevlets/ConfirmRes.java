package Sevlets;

<<<<<<< HEAD
import java.io.IOException;
=======
import DAO.ReservationDAO;
import MYSQLIMP.ReservationDAOImpl;
import Modals.Reservation;
<<<<<<< HEAD
=======
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
>>>>>>> 1ca07078820061a6a3ecc05655c947f1696bcd54

import java.io.*;
>>>>>>> 408becb97dd376bc0c0528c385895244d960b119
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReservationDAO;
import MYSQLIMP.ReservationDAOImpl;
import Modals.Reservation;

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