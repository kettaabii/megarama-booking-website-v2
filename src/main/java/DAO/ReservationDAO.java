package DAO;

import java.sql.SQLException;
import java.util.List;

import Modals.Reservation;

public interface ReservationDAO {

    void insertReservation(Reservation reservation) throws SQLException;


    List<Reservation> getAllReservations() throws SQLException;


    void updateReservation(Reservation reservation) throws SQLException;


    void deleteReservation(int reservationId) throws SQLException;
}
