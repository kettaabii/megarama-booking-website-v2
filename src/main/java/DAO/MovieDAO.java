package DAO;

import Modals.Movie;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface MovieDAO {
    // Method to insert a new movie
    void insertMovie(Movie movie) throws SQLException, ParseException;

    // Method to retrieve all movies
    List<Movie> getAllMovies() throws SQLException;

    List<Movie> getFiveMovies() throws SQLException;

    // Method to retrieve a movie by its ID
    Movie getMovieById(int filmId) throws SQLException;

    // Method to update a movie
    void updateMovie(Movie movie) throws SQLException;

    // Method to delete a movie
    void deleteMovie(int filmId) throws SQLException;


    List<Movie> searchMoviesByTitle(String title) throws SQLException;
}

