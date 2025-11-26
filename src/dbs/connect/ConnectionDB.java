package dbs.connect;

import java.sql.*;

public class ConnectionDB {
    public static void main(String[] args) {
        // Always surround connection and driver name initialization inside try and catch
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/infodb", "DakshSingh", "dakshsingh"
            );
            if (connection.isValid(10)) IO.println("Connected");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");

            // Iterate through ResultSet can be done by .next() method; breakdown: if .next() returns something, then do the task otherwise, stop right there and then
            while (resultSet.next()) {
                // "transact_id", and "holder_f_name"
                int id = resultSet.getInt("transaction_acct");
                String userName = resultSet.getString("holder_f_name");
                IO.println("Account ID: " + id + ", Account Holder: " + userName);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
