package Sevlets;

import DAO.ReservationDAO;
import DAO.WatchLaterDAO;
import MYSQLIMP.ReservationDAOImpl;
import MYSQLIMP.WatchlaterDAOImp;
import Modals.Reservation;
import Modals.Watchlater;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddToWatchlist")
public class AddToWatchlistServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WatchlaterDAOImp watchLaterDAO = new WatchlaterDAOImp();
        String viewer = (String) req.getSession().getAttribute("username");
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        String cover = req.getParameter("cover");

        req.setAttribute("title", title);
        req.setAttribute("viewer", viewer);
        req.setAttribute("genre", genre);
        req.setAttribute("cover", cover);

        Watchlater watchlater = new Watchlater(viewer, title, genre, cover);

        try {
            watchLaterDAO.AddToWatchLater(watchlater);
            req.getRequestDispatcher("/Watchlist.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
            // Optionally, you can redirect to an error page
            // resp.sendRedirect("/error.jsp");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}