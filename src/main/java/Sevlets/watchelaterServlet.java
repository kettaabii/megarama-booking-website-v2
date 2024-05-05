package Sevlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/watchelaterServlet")
public class watchelaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public watchelaterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("userId");
	    int filmId = Integer.parseInt(request.getParameter("filmId"));
	    String title = request.getParameter("title");
	    String description = request.getParameter("description");
	    Date addedDate = new Date(); 

	    // Add movie to the watch_later table in the database
	    try {
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/megarama", "username", "password");
	        String movieSql = "SELECT * FROM movies WHERE filmId = ?";
	        PreparedStatement movieStatement = conn.prepareStatement(movieSql);
	        movieStatement.setInt(1, filmId);
	        ResultSet resultSet = movieStatement.executeQuery();
	        if(resultSet.next()) {
	            String sql = "INSERT INTO watch_later (userId, filmId, addedDate, Title, Dsecription, releaseDate, Duration, Genre, Director, Cover, MegaCover) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, userId);
	            statement.setInt(2, resultSet.getInt("filmId"));
	            statement.setDate(3, new java.sql.Date(addedDate.getTime()));
	            statement.setString(4, resultSet.getString("Title"));
	            statement.setString(5, resultSet.getString("Dsecription"));
	            statement.setDate(6, resultSet.getDate("releaseDate"));
	            statement.setInt(7, resultSet.getInt("Duration"));
	            statement.setString(8, resultSet.getString("Genre"));
	            statement.setString(9, resultSet.getString("Director"));
	            statement.setString(10, resultSet.getString("Cover"));
	            statement.setString(11, resultSet.getString("MegaCover"));
	            statement.executeUpdate();
	            statement.close();
	        }
	        resultSet.close();
	        movieStatement.close();
	        conn.close();
	        response.sendRedirect("watch_later.jsp"); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
