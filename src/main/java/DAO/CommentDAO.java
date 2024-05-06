package DAO;

import Modals.Comment;

import java.sql.SQLException;

public interface CommentDAO {

    void AddComment(Comment comment) throws SQLException;
}
