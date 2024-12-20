package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
connection = DriverManager.getConnection(
    "jdbc:mysql://74.234.181.15:3306/chatapplication?connectTimeout=10000&socketTimeout=10000", 
    "hos", 
    "hos"
);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }
}
