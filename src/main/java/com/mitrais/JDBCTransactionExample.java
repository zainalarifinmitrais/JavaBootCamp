package com.mitrais;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransactionExample {
    private static final String dbURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Test;";
    private static final String username = "sa";
    private static final String password = "Green123";

    public static void main(String[] argv) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementUpdate = null;

        String insertTableSQL = "INSERT INTO dbUsers1"
                + "(user_id, username, created_by, created_date) VALUES"
                + "(?,?,?,?)";

        String updateTableSQL = "UPDATE dbUsers1 SET username =? "
                + "WHERE user_id = ?";

        try {
            dbConnection = getDBConnection();

            dbConnection.setAutoCommit(false);

            preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);
            preparedStatementInsert.setInt(1, 999);
            preparedStatementInsert.setString(2, "mkyong101");
            preparedStatementInsert.setString(3, "system");
            preparedStatementInsert.setTimestamp(4, getCurrentTimeStamp());
            preparedStatementInsert.executeUpdate();

            preparedStatementUpdate = dbConnection.prepareStatement(updateTableSQL);
            // preparedStatementUpdate.setString(1,
            // "A very very long string caused db error");
            preparedStatementUpdate.setString(1, "new string");
            preparedStatementUpdate.setInt(2, 999);
            preparedStatementUpdate.executeUpdate();

            dbConnection.commit();

            System.out.println("Done!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementInsert != null) {
                preparedStatementInsert.close();
            }

            if (preparedStatementUpdate != null) {
                preparedStatementUpdate.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;
        try {

            dbConnection = DriverManager.getConnection(dbURL, username, password);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

}
