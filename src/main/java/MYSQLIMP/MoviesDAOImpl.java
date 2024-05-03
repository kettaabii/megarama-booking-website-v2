package MYSQLIMP;

import DAO.MovieDAO;
import Modals.Movie;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAOImpl implements MovieDAO {
    public Connection connection;



    @Override
    public void insertMovie(Movie movie) throws SQLException, ParseException {
        String sql = "INSERT INTO movies (filmId, Title, Dsecription, releaseDate, Duration, Genre, Director, Cover,MegaCover) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        Connection con = Connectiondb.getConnection();
        System.out.println();
        PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, movie.getFilmId());
            statement.setString(2, movie.getTitle());
            statement.setString(3, movie.getDescription());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date parsedReleaseDate = dateFormat.parse(movie.getReleaseDate());
            statement.setDate(4, new java.sql.Date(parsedReleaseDate.getTime()));
            statement.setInt(5, movie.getDuration());
            statement.setString(6, movie.getGenre());
            statement.setString(7, movie.getDirector());
            statement.setString(8, movie.getCover());
            statement.setString(9, movie.getMegaCover());
            statement.executeUpdate();
        }


    @Override
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int filmId = resultSet.getInt("filmId");
                String title = resultSet.getString("Title");
                String description = resultSet.getString("Dsecription");
                String releaseDate = resultSet.getDate("releaseDate").toString();
                int duration = resultSet.getInt("Duration");
                String genre = resultSet.getString("Genre");
                String director = resultSet.getString("Director");
                String cover = resultSet.getString("Cover");
                String megaCover = resultSet.getString("MegaCover");

                Movie movie = new Movie(filmId, title, description, releaseDate, duration, genre, director, cover, megaCover);
                movies.add(movie);
            }

        return movies;
    }

    @Override
    public Movie getMovieById(int filmId) throws SQLException {
        String sql = "SELECT * FROM movies WHERE filmId=?";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,filmId);
        ResultSet resultSet = statement.executeQuery();



                if (resultSet.next()) {
                    String title = resultSet.getString("Title");
                    String description = resultSet.getString("Dsecription");
                    String releaseDate = resultSet.getDate("releaseDate").toString();
                    int duration = resultSet.getInt("Duration");
                    String genre = resultSet.getString("Genre");
                    String director = resultSet.getString("Director");
                    String cover = resultSet.getString("Cover");
                    String megaCover = resultSet.getString("MegaCover");

                    return new Movie(filmId, title, description, releaseDate, duration, genre, director, cover, megaCover);
                }

        return null;
    }



    @Override
    public void updateMovie(Movie movie) throws SQLException {
        String sql = "UPDATE movies SET Title=?, Description=?, releaseDate=?, Duration=?, Genre=?, Director=?, Cover=?,MegaCover=? WHERE filmId=?";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);


            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getDescription());
            statement.setString(3, movie.getReleaseDate());
            statement.setInt(4, movie.getDuration());
            statement.setString(5, movie.getGenre());
            statement.setString(6, movie.getDirector());
            statement.setString(7, movie.getCover());
            statement.setInt(8, movie.getFilmId());
            statement.executeUpdate();

    }

    @Override
    public void deleteMovie(int filmId) throws SQLException {
        String sql = "DELETE FROM movies WHERE filmId=?";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);

        statement.setInt(1, filmId);
        statement.executeUpdate();
    }

    public List<Movie> searchMoviesByTitle(String title) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies WHERE Title LIKE ?";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + title + "%");
        ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int filmId = resultSet.getInt("filmId");
                    String movieTitle = resultSet.getString("Title");
                    String description = resultSet.getString("Description");
                    String releaseDate = resultSet.getDate("releaseDate").toString();
                    int duration = resultSet.getInt("Duration");
                    String genre = resultSet.getString("Genre");
                    String director = resultSet.getString("Director");
                    String cover = resultSet.getString("Cover");
                    String MegaCover = resultSet.getString("MegaCover");
                    Movie movie = new Movie(filmId, movieTitle, description, releaseDate, duration, genre, director, cover,MegaCover);
                    movies.add(movie);
                }

      return movies;

    }
}
