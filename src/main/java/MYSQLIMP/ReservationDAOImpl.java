package MYSQLIMP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ReservationDAO;
import Modals.Reservation;

public class ReservationDAOImpl implements ReservationDAO {
    public Connection connection;



    @Override
    public void insertReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation (reservationId, viewer, filmTitle, reservationDate, price, seat) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, reservation.getReservationId());
            statement.setString(2, reservation.getViewer());
            statement.setString(3, reservation.getFilmTitle());
            statement.setDate(4, new java.sql.Date(reservation.getReservationDate().getTime()));
            statement.setInt(5, reservation.getPrice());
            statement.setString(6, reservation.getSeat());
            statement.executeUpdate();

    }

    @Override
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        System.out.println(reservations +"REEEEEEEEEEEESEEEEEEEERRRRRVVVVAAAATTTTIIIIOOONNNSS");
        String sql = "SELECT * FROM reservation";
        Connection con = Connectiondb.getConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int reservationId = resultSet.getInt("reservationId");
                String viewer = resultSet.getString("viewer");
                String filmTitle = resultSet.getString("filmTitle");
                Date reservationDate = resultSet.getDate("reservationDate");
                int price = resultSet.getInt("price");
                String seat = resultSet.getString("seat");

                Reservation reservation = new Reservation(reservationId, viewer, filmTitle, reservationDate, (int) price, seat);
                reservations.add(reservation);
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
            statement.setString(5, reservation.getSeat());
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

