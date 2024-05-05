package MYSQLIMP;

import DAO.ReservationDAO;
import Modals.HibernateUtil;
import Modals.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;



public class ReservationDAOImpl implements ReservationDAO {
    public Connection connection;



    @Override
    public void insertReservation(Reservation reservation) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.save(reservation);
        session.beginTransaction().commit();
        session.close();

    }

    @Override
    public List<Reservation> getAllReservations() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Reservation> query = session.createQuery("Select t from Reservation t", Reservation.class).getResultList();
        List<Reservation> reservations = query;
        transaction.commit();
        session.close();
        return reservations;}
    @Override
    public List<Reservation> getReservatioByUser(String viewer) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        List<Reservation> query = session.createQuery("SELECT p from Reservation t JOIN t.viewer p WHERE t.viewer = :pusername", Reservation.class).getResultList();
        List<Reservation> reservations = query;
        transaction.commit();
        session.close();
        return reservations;
//        List<Reservation> reservations = new ArrayList<>();
//        System.out.println(reservations +"REEEEEEEEEEEESEEEEEEEERRRRRVVVVAAAATTTTIIIIOOONNNSS");
//        String sql = "SELECT * FROM reservation";
//        Connection con = Connectiondb.getConnection();
//        PreparedStatement statement = con.prepareStatement(sql);
//        ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int reservationId = resultSet.getInt("reservationId");
//                String viewer = resultSet.getString("viewer");
//                String filmTitle = resultSet.getString("filmTitle");
//                Date reservationDate = resultSet.getDate("reservationDate");
//                int price = resultSet.getInt("price");
//                String seat = resultSet.getString("seat");
//
//                Reservation reservation = new Reservation(reservationId, viewer, filmTitle, reservationDate, (int) price, seat);
//                reservations.add(reservation);
//            }
//
//        return reservations;

    }



    @Override
    public void deleteReservation(int reservationId) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Reservation reservation = (Reservation)session.load(Reservation.class,reservationId);
        session.delete(reservation);

        //This makes the pending delete to be done
        session.flush() ;
        session.close();

    }}


