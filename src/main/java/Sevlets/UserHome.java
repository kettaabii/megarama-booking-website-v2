package Sevlets;

import java.io.*;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserHome-servlet")
public class UserHome extends HttpServlet {




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        request.getRequestDispatcher("/moviesUser.jsp");
    }

    public void destroy() {
    }
}