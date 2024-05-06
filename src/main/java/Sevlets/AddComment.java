package Sevlets;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CommentDAO;
import 	MYSQLIMP.CommentDaoimp;
import Modals.Comment;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            CommentDAO commentDAO = new CommentDaoimp();
        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
        String commentaire = request.getParameter("comment");
        String viewer = request.getParameter("viewer");

        int rating = Integer.parseInt(request.getParameter("rating"));


        // Create a Comment object
       Comment comment=new Comment(commentaire,viewer,rating,movie_id);
        System.out.println(comment +"lllllllllllllllllllllllllllllllllllllllllllllllll");
        // Assuming commentDAO is properly initialized
        try {
            commentDAO.AddComment(comment);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }}