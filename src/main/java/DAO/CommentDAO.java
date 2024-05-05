package DAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import Modals.Comment;


public interface CommentDAO {
    void addComment(Comment comment) throws SQLException, ParseException;
    List<Comment> getAllComments() throws SQLException;
}
