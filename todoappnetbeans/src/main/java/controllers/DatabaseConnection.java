package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected static Connection initializeConnection() throws SQLException, ClassNotFoundException{
        String dbDriver = "com.mysql.jdbc.driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "todoappdb";
        String dbUsername = "todoUser";
        String dbPassword = "aaaa1234";
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL+dbName,dbUsername,dbPassword);
        return con;
    }
}
