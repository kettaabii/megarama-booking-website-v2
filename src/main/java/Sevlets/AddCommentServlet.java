package Sevlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modals.Comment;
import DAO.CommentDAO;
import MYSQLIMP.CommentDAOImpl;

@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentDAO commentDAO;

    public AddCommentServlet() {
        super();
        this.commentDAO = new CommentDAOImpl();    }

    
    
    
    
    
    
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String description = request.getParameter("description");
        int rating = Integer.parseInt(request.getParameter("rating"));

        // Create a Comment object
        Comment comment = new Comment(movieId, userId, description, rating);
        
        // Assuming commentDAO is properly initialized
        commentDAO.addComment(comment);

        // Redirect back to index.jsp or any other appropriate page
        response.sendRedirect("index.jsp");
    }}

    
    
    
    
    
   