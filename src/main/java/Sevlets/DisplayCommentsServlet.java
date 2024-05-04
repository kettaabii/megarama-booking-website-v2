package Sevlets;
import Modals.Comment;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.DbUtils;

import DAO.CommentDAO;
import Modals.Movie;
import Modals.User;
import MYSQLIMP.CommentDAOImpl;
import org.apache.commons.dbutils.DbUtils;

public class DisplayCommentsServlet extends HttpServlet {
    private CommentDAO commentDAO;

    public void init() throws ServletException {
        Connection connection = DBUtils.getConnection();
        commentDAO = new CommentDAOImpl(connection);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = commentDAO.getAllComments();
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("comments.jsp").forward(request, response);
    }
}
Page JSP comments.jsp :
jsp
Copy code
<!DOCTYPE html>
<html>
<head>
    <title>Comments</title>
</head>
<body>
    <h1>Comments</h1>
    <ul>
        <c:forEach var="comment" items="${comments}">
            <li>
                <p><strong>Movie ID:</strong> ${comment.movieId}</p>
                <p><strong>User ID:</strong> ${comment.userId}</p>
                <p><strong>Description:</strong> ${comment.description}</p>
                <p><strong>Rating:</strong> ${comment.rating}</p>
            </li>
        </c:forEach>
    </ul>
</body>
</html>