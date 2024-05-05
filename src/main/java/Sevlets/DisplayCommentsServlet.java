package Sevlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CommentDAO;
import MYSQLIMP.CommentDAOImpl;
public class DisplayCommentsServlet extends HttpServlet {
    public CommentDAO commentDAO;

    public void init() throws ServletException {
        commentDAO = new CommentDAOImpl(); 
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CommentDAO res = new CommentDAOImpl();

	try {
		request.setAttribute("Reservationlist", res.getAllComments());
		System.out.println(res.getAllComments()+"fhdjgf");
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	request.getRequestDispatcher("/BookMovie.jsp").forward(request,response);

  
    }


}


