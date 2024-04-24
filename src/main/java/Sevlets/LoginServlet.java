package Sevlets;

import DAO.UserDAO;
import MYSQLIMP.UserDAOImpl;
import Modals.User;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Authenticate user credentials
        UserDAO userDAO = new UserDAOImpl();
        User user = null;
        try {
            user = userDAO.getUserByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user != null) {
            HttpSession session = request.getSession();

            if ("admin".equalsIgnoreCase(user.getPrivilege())) {
                // Set session attribute to mark user as logged in
                session.setAttribute("adminLoggedIn", true);
                // Redirect to admin dashboard
                response.sendRedirect("adlogin.jsp");
            } else if ("client".equalsIgnoreCase(user.getPrivilege())) {
                // Set session attribute to mark user as logged in
                session.setAttribute("clientLoggedIn", true);
                // Redirect to client dashboard
                response.sendRedirect("cllogin.jsp");
            } else {
                // Invalid privilege
                response.sendRedirect("login.jsp?error=Invalid privilege");
            }
        } else {
            // Invalid credentials
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
}
