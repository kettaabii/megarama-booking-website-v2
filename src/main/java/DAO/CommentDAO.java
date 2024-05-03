package DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import Modals.Movie;

public interface CommentDAO {
	void insertcomment(Comment comment) throws SQLException, ParseException;
	
	List<Comment> getAllComments() throws SQLException;
}
