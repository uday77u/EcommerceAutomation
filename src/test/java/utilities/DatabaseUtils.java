package utilities;

import java.sql.*;

public class DatabaseUtils {
    private static Connection connection;

    public static void connect(String dbUrl, String dbUser, String dbPassword) {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("✅ Connected to DB");
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to connect to DB", e);
        }
    }

    public static ResultSet runQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to run query", e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🛑 DB connection closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to close DB connection", e);
        }
    }
}
