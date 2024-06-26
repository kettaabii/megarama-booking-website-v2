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
import MYSQLIMP.WatchlaterDAOImp;
import Modals.Reservation;


@WebServlet("/Watchlist")
public class WatchList extends HttpServlet {
    private static final long serialVersionUID = 1L;



    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WatchlaterDAOImp wishlist = new WatchlaterDAOImp();
        String viewer = (String) request.getSession().getAttribute("username");

        request.setAttribute("wishlist", wishlist.getWishlist(viewer));
        System.out.println(wishlist.getWishlist(viewer)+"LLLLMMMMMMKKK");
        request.getRequestDispatcher("/Watchlist.jsp").forward(request,response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        ReservationDAO resuser= new ReservationDAOImpl();
        String viewer= (String) request.getSession().getAttribute("username");
        doGet(request, response);
    }

}
