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
import 	MYSQLIMP.CommentDAOImpl;
import Modals.Comment;

@WebServlet("/AddComment")
public class AddCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentDAO commentDAO;

    public AddCommentServlet() {
        super();
        this.commentDAO = new CommentDAOImpl();    }

    
    
    
    
    
    
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String description = request.getParameter("description");
        int rating = Integer.parseInt(request.getParameter("rating"));
       
        // Create a Comment object
        Comment comment = new Comment(movie_id, user_id, description, rating);
        System.out.println(comment +"lllllllllllllllllllllllllllllllllllllllllllllllll");
        // Assuming commentDAO is properly initialized
        try {
			commentDAO.addComment(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
    }}