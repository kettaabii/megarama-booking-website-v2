package MYSQLIMP;
import DAO.WatchLaterDAO;
import Modals.HibernateUtil;
import Modals.Reservation;
import Modals.Watchlater;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class WatchlaterDAOImp implements WatchLaterDAO {
    @Override
    public void AddToWatchLater(Watchlater watchlater){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(watchlater);
        System.out.println(watchlater+" added to watchlater");
        session.beginTransaction().commit();
        session.close();


    }
    @Override
    public List<Watchlater>getWishlist(String viewer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Watchlater> wishlist = null;

        try {
            transaction = session.beginTransaction();
            Query<Watchlater> query = session.createQuery("SELECT t FROM Watchlater t WHERE t.viewer = :viewer", Watchlater.class);
            query.setParameter("viewer", viewer);
            wishlist = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle the exception appropriately
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return wishlist;


    }
    @Override
    public void RemoveFromWatchLater(Watchlater watchlater){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(watchlater);
        tx.commit();
        session.close();
    }
}
