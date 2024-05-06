package MYSQLIMP;

import DAO.CommentDAO;
import Modals.Comment;
import Modals.HibernateUtil;
import org.hibernate.Session;

import java.sql.*;

public class CommentDaoimp implements CommentDAO {
    @Override
    public void AddComment(Comment comment) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.save(comment);
        session.beginTransaction().commit();
        session.close();

    }

}
