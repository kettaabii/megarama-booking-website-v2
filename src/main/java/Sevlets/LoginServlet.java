package Sevlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import MYSQLIMP.Connectiondb;
import MYSQLIMP.UserDAOImpl;
import Modals.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        try (Connection connection = Connectiondb.getConnection()) {
            UserDAO userDAO = new UserDAOImpl(connection);
            User user = userDAO.getUserByUsernameAndPassword(username, password);

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
                    session.setAttribute("username", user.getUserName());
                    System.out.println(user.getUserName() +"::::::::::::::::::");
                    // Redirect to client dashboard
                    response.sendRedirect(request.getContextPath()+"/");
                } else {
                    // Invalid privilege
                    response.sendRedirect("login.jsp?error=Invalid privilege");
                }
            } else {
                // Invalid credentials
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        } catch (SQLException e) {
            throw new ServletException("Error accessing database", e);
        }
    }
}
