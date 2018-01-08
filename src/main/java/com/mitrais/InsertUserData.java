package com.mitrais;

import java.sql.*;

public class InsertUserData {

    private static String dbURL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Test;";
    private static String username = "sa";
    private static String password = "Green123";

    public static void main(String[] argv) {

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) System.out.println("Connected");

            //Insert

            String sql = "INSERT INTO Users (user_id, username, password, fullname, email) VALUES (?,?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "1");
            statement.setString(2, "bill");
            statement.setString(3, "secretpass");
            statement.setString(4, "Bill Gates");
            statement.setString(5, "bill.gates@microsoft.com");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

            //Select
            String sqlSelect = "SELECT * FROM Users";

            Statement selectStatement = conn.createStatement();
            ResultSet result = selectStatement.executeQuery(sqlSelect);

            int count = 0;

            while (result.next()){
                String name = result.getString(2);
                String pass = result.getString(3);
                String fullname = result.getString("fullname");
                String email = result.getString("email");

                String output = "User #%d: %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, name, pass, fullname, email));
            }

            //Update
            String sqlUpdate = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";

            PreparedStatement updateStatement = conn.prepareStatement(sqlUpdate);
            updateStatement.setString(1, "123456789");
            updateStatement.setString(2, "William Henry Bill Gates");
            updateStatement.setString(3, "bill.gates@microsoft.com");
            updateStatement.setString(4, "bill");

            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }

            //Delete
            String deleteSql = "DELETE FROM Users WHERE username=?";

            PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
            deleteStatement.setString(1, "bill");

            int rowsDeleted = deleteStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }


            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
