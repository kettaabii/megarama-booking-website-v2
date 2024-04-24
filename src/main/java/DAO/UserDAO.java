package DAO;

import Modals.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void insertUser(User user) throws SQLException;


    List<User> getAllUsers() throws SQLException;


    User getUserById(int userId) throws SQLException;


    void updateUser(User user) throws SQLException;


    void deleteUser(int userId) throws SQLException;

    User getUserByUsernameAndPassword(String username, String password) throws SQLException;
}

