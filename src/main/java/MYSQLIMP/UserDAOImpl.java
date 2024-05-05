package MYSQLIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UserDAO;
import Modals.User;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDAOImpl() {

    }


    @Override
    public void insertUser(User user) throws SQLException {

        String sql = "INSERT INTO users (userId, userName, Pass, Privilege, Email) VALUES (?, ?, ?, ?, ?)";
        connection = Connectiondb.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPrivilege());
            statement.setString(5, user.getEmail());
            statement.executeUpdate();
        }
    }
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE userName = ? AND Pass = ?";
        connection = Connectiondb.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt("userId");
                    String privilege = resultSet.getString("privilege");
                    String email = resultSet.getString("email");

                    return new User(userId, username, password, privilege, email);
                }
            }
        }
        return null;
    }
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("Pass");
                String privilege = resultSet.getString("Privilege");
                String email = resultSet.getString("Email");

                User user = new User(userId, userName, password, privilege, email);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userName = resultSet.getString("userName");
                    String password = resultSet.getString("Pass");
                    String privilege = resultSet.getString("Privilege");
                    String email = resultSet.getString("Email");

                    return new User(userId, userName, password, privilege, email);
                }
            }
        }
        return null;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET userName=?, Pass=?, Privilege=?, Email=? WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPrivilege());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getUserId());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE userId=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }

}
