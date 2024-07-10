package com.management.thithuchanhmodule3.repository.connecdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecDatabase {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/codegym?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "0339198933ky";
    private static Connection connection = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
