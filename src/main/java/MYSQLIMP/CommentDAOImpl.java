package MYSQLIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DAO.Comment;
import DAO.CommentDAO;
import Modals.Movie;

public class CommentDAOImpl {
	  public Connection connection;



	    @Override
	    void insertcomment(Comment comment) throws SQLException, ParseException {
	        String sql = "INSERT INTO comments (id, filmId, userId, description) VALUES (?, ?, ?, ?)";
	        Connection con = Connectiondb.getConnection();
	        
	        System.out.println();
	        
	        PreparedStatement statement = con.prepareStatement(sql);
	            statement.setInt(1, comment.getId());
	            statement.setInt(2, comment.getFilmId());
	            statement.setInt(3, comment.getFilmId());
	            statement.setString(4, comment.getDescription());
	            statement.executeUpdate();
	        }
}







@Override
List<Comment> getAllComments() throws SQLException {
    List<Comment> comments = new ArrayList<>();
    String sql = "SELECT * FROM comment";
    Connection con = Connectiondb.getConnection();
    PreparedStatement statement = con.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int filmId = resultSet.getInt("filmId");
            int userId = resultSet.getInt("userId");
            String description = resultSet.getString("decription");
            

            Comment comment = new Comment(id, filmId, userId, description);
            comments.add(comment);
        }

    return comments;
}



