package DAO;

import Modals.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO {

    void insertReservation(Reservation reservation) throws SQLException;


    List<Reservation> getAllReservations() throws SQLException;





    void deleteReservation(int reservationId) throws SQLException;

    List<Reservation> getReservationByUser(String viewer) throws SQLException;
}
