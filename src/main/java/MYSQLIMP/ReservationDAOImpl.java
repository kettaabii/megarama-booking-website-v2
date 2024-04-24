package MYSQLIMP;

import DAO.ReservationDAO;
import Modals.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private Connection connection;

    // Constructor to initialize the connection
    public ReservationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservations (reservationId, viewer, filmTitle, reservationDate, price, seat) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservation.getReservationId());
            statement.setString(2, reservation.getViewer());
            statement.setString(3, reservation.getFilmTitle());
            statement.setDate(4, new java.sql.Date(reservation.getReservationDate().getTime()));
            statement.setDouble(5, reservation.getPrice());
            statement.setInt(6, reservation.getSeat());
            statement.executeUpdate();
        }
    }

    @Override
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int reservationId = resultSet.getInt("reservationId");
                String viewer = resultSet.getString("viewer");
                String filmTitle = resultSet.getString("filmTitle");
                Date reservationDate = resultSet.getDate("reservationDate");
                double price = resultSet.getDouble("price");
                int seat = resultSet.getInt("seat");

                Reservation reservation = new Reservation(reservationId, viewer, filmTitle, reservationDate, (int) price, seat);
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    @Override
    public void updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservations SET viewer=?, filmTitle=?, reservationDate=?, price=?, seat=? WHERE reservationId=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, reservation.getViewer());
            statement.setString(2, reservation.getFilmTitle());
            statement.setDate(3, new java.sql.Date(reservation.getReservationDate().getTime()));
            statement.setInt(4, reservation.getPrice());
            statement.setInt(5, reservation.getSeat());
            statement.setInt(6, reservation.getReservationId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteReservation(int reservationId) throws SQLException {
        String sql = "DELETE FROM reservations WHERE reservationId=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservationId);
            statement.executeUpdate();
        }
    }
}

