package DAO;

import Modals.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    // Method to insert a new user
    void insertUser(User user) throws SQLException;

    // Method to retrieve all users
    List<User> getAllUsers() throws SQLException;

    // Method to retrieve a user by their ID
    User getUserById(int userId) throws SQLException;

    // Method to update a user
    void updateUser(User user) throws SQLException;

    // Method to delete a user
    void deleteUser(int userId) throws SQLException;
    User getUserByUsernameAndPassword(String username, String password) throws SQLException;

}
