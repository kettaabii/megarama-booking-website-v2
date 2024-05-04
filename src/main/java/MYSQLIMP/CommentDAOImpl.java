package MYSQLIMP;
import DAO.CommentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modals.Comment;



public class CommentDAOImpl implements CommentDAO {
    private Connection connection;
    public CommentDAOImpl() {
        // Initialization code if needed
    }

    public CommentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addComment(Comment comment) {
        try {
            String sql = "INSERT INTO comments (movie_id, user_id, description, rating) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, comment.getMovieId());
            statement.setInt(2, comment.getUserId());
            statement.setString(3, comment.getDescription());
            statement.setInt(4, comment.getRating());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comments";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(
                    resultSet.getInt("movie_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("description"),
                    resultSet.getInt("rating")
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}