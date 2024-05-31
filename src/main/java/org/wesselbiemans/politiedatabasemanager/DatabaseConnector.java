package org.wesselbiemans.politiedatabasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/politie_database";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // JDBC connection object
    private static Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnector() {}

    // Method to establish and return a database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error connecting to the database", e);
            }
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error closing the connection", e);
            }
        }
    }

    // Method to verify credentials
    public static boolean verifyCredentials(String username, String password) {
        String query = "SELECT * FROM `politie account` WHERE userName = ? AND userPassword = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error checking credentials", e);
        }
    }
}
