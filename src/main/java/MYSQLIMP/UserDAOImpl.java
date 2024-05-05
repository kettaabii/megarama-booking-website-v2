package MYSQLIMP;

import DAO.UserDAO;
import Modals.HibernateUtil;
import Modals.Movie;
import Modals.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDAOImpl() {

    }


    @Override
    public void insertUser(User user) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return Collections.emptyList();
    }

//    @Override
//    public void insertUser(User user) throws SQLException {
//
//        String sql = "INSERT INTO users (userId, userName, Pass, Privilege, Email) VALUES (?, ?, ?, ?, ?)";
//        connection = Connectiondb.getConnection();
//        try (
//                PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, user.getUserId());
//            statement.setString(2, user.getUserName());
//            statement.setString(3, user.getPassword());
//            statement.setString(4, user.getPrivilege());
//            statement.setString(5, user.getEmail());
//            statement.executeUpdate();
//        }
//    }
  public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction transaction = session.beginTransaction();
      Query<User> query = session.createQuery("FROM User WHERE userName = :username AND password = :password", User.class);
      query.setParameter("username", username);
      query.setParameter("password", password);
      User user = query.uniqueResult();
      session.close();
      return user;
  }
//        String sql = "SELECT * FROM users WHERE userName = ? AND Pass = ?";
//        connection = Connectiondb.getConnection();
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, username);
//            statement.setString(2, password);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    int userId = resultSet.getInt("userId");
//                    String privilege = resultSet.getString("privilege");
//                    String email = resultSet.getString("email");
//
//                    return new User(userId, username, password, privilege, email);
//                }
//            }
//        }
//        return null;
//    }
//    @Override
//    public List<User> getAllUsers() throws SQLException {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (PreparedStatement statement = connection.prepareStatement(sql);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                int userId = resultSet.getInt("userId");
//                String userName = resultSet.getString("userName");
//                String password = resultSet.getString("Pass");
//                String privilege = resultSet.getString("Privilege");
//                String email = resultSet.getString("Email");
//
//                User user = new User(userId, userName, password, privilege, email);
//                users.add(user);
//            }
//        }
//        return users;
//    }

    @Override
    public User getUserById(int userId) throws SQLException {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        user = session.load(User.class, userId);
        Hibernate.initialize(user);
        session.close();
        return  user;

    }

    @Override
    public void updateUser(User user) throws SQLException {

    }

    @Override
    public void deleteUser(int userId) throws SQLException {

    }



//    @Override
//    public void updateUser(User user) throws SQLException {
//        String sql = "UPDATE users SET userName=?, Pass=?, Privilege=?, Email=? WHERE userId=?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, user.getUserName());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getPrivilege());
//            statement.setString(4, user.getEmail());
//            statement.setInt(5, user.getUserId());
//            statement.executeUpdate();
//        }
//    }
//
//    @Override
//    public void deleteUser(int userId) throws SQLException {
//        String sql = "DELETE FROM users WHERE userId=?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, userId);
//            statement.executeUpdate();
//        }
//    }

}
