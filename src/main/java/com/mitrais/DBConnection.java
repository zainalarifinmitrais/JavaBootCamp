package com.mitrais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String dbURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Test;";
    private static final String username = "sa";
    private static final String password = "Green123";

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

}
