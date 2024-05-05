package MYSQLIMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import DAO.CommentDAO;
import Modals.Comment;



public class CommentDAOImpl implements CommentDAO {
    public Connection connection;
	private int user_id;
	private int movie_id;
	private int rating;
	private String description;

    
    @Override
    public void addComment(Comment comment) throws SQLException, ParseException {
        String sql = "INSERT INTO comments (movie_id, user_id, description, rating) VALUES (?, ?, ?, ?)";
        Connection con = Connectiondb.getConnection();
        System.out.println();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, comment.getMovie_id());
        statement.setInt(2, comment.getUser_id());
        statement.setString(3, comment.getDescription());
        statement.setInt(4, comment.getRating());
        statement.executeUpdate();
        }
    
    

    @Override
    public List<Comment> getAllComments() throws SQLException {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	resultSet.getInt("movie_id");
                resultSet.getInt("user_id");
                resultSet.getString("description");
                resultSet.getInt("rating");

               
				Comment comment = new Comment(movie_id,user_id,description,rating);
                comments.add(comment);
            }

        return comments;
    }}


    