package DAO;
import java.util.List;
import Modals.Comment;


public interface CommentDAO {
    void addComment(Comment comment);
    List<Comment> getAllComments();
}
