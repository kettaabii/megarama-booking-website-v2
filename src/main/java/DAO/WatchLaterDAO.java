package DAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Modals.Movie;

public interface WatchLaterDAO {
    // Method to add a movie to the watch later list for a specific user
	void addMovieToWatchLater(String userId, int filmId, String title, String description, Date addedDate)
			throws SQLException;

    // Method to remove a movie from the watch later list for a specific user
    void removeMovieFromWatchLater(int userId, int filmId);

    // Method to get all movies in the watch later list for a specific user
    List<Movie> getWatchLaterMovies(int userId);

    // Method to check if a movie is in the watch later list for a specific user
    boolean isMovieInWatchLater(int userId, int filmId);

	
}
