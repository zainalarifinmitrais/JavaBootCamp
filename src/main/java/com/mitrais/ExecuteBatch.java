package com.mitrais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class ExecuteBatch {

    public static void main(String[] argv)  {
        try (Connection connection = DBConnection.getConnection())
        {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO dbUsers1 (user_id, username, created_by, created_date) VALUES (?,?,?,?)");)
            {
                pstmt.setInt(1, 1);
                pstmt.setString(2,"test1");
                pstmt.setString(3,"test1");
                pstmt.setTimestamp(4,getCurrentTimeStamp());
                pstmt.addBatch();
                pstmt.setInt(1, 2);
                pstmt.setString(2,"test2");
                pstmt.setString(3,"test2");
                pstmt.setTimestamp(4,getCurrentTimeStamp());
                pstmt.addBatch();
                pstmt.setInt(1, 3);
                pstmt.setString(2,"test3");
                pstmt.setString(3,"test3");
                pstmt.setTimestamp(4,getCurrentTimeStamp());
                pstmt.addBatch();
                int[] arr = pstmt.executeBatch();
                System.out.println(Arrays.toString(arr));
                connection.commit();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                connection.rollback();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
}
