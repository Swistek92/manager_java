package utils;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final Dotenv dotenv = Dotenv.load(); // Ładuje zmienne z pliku .env

    private static final String DATABASE_URL = dotenv.get("DATABASE_URL");
    private static final String DATABASE_USER = dotenv.get("DATABASE_USER");
    private static final String DATABASE_PASSWORD = dotenv.get("DATABASE_PASSWORD");
    private static Connection connection = null;

    /**
     * Establishes a connection to the MySQL database.
     */
    public static void connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
                System.out.println("Connection to MySQL database has been established.");
                System.out.println("Connection to MySQL database has been established.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    /**
     * Returns the active database connection.
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    /**
     * Closes the database connection to release resources.
     */
    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection to MySQL database has been closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close the database connection: " + e.getMessage());
        }
    }
}
