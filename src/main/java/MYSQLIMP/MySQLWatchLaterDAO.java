package MYSQLIMP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import DAO.WatchLaterDAO;
import Modals.Movie;

public class MySQLWatchLaterDAO implements WatchLaterDAO {
    private String url = "jdbc:mysql://localhost:3306/megarama";
    private String username = "root";
    private String password = "";

    @Override
    public void addMovieToWatchLater(String userId, int filmId, String title, String description, Date addedDate) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String movieSql = "SELECT * FROM movies WHERE filmId = ?";
            try (PreparedStatement movieStatement = conn.prepareStatement(movieSql)) {
                movieStatement.setInt(1, filmId);
                try (ResultSet resultSet = movieStatement.executeQuery()) {
                    if(resultSet.next()) {
                        String sql = "INSERT INTO watch_later (userId, filmId, addedDate, Title, Dsecription, releaseDate, Duration, Genre, Director, Cover, MegaCover) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement statement = conn.prepareStatement(sql)) {
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
                        }
                    }
                }
            }
        }
    }

	@Override
	public void removeMovieFromWatchLater(int userId, int filmId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movie> getWatchLaterMovies(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMovieInWatchLater(int userId, int filmId) {
		// TODO Auto-generated method stub
		return false;
	}
}
