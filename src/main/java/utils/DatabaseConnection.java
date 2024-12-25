package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final Dotenv dotenv = Dotenv.load(); // Ładuje zmienne z pliku .env
    private static final String DATABASE_URL = dotenv.get("DATABASE_URL");
    private static final String DATABASE_USER = dotenv.get("DATABASE_USER");
    private static final String DATABASE_PASSWORD = dotenv.get("DATABASE_PASSWORD");
    // Stałe z wbudowanymi zmiennymi konfiguracyjnymi
    // private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/student_management";
    // private static final String DATABASE_USER = "root";
    // private static final String DATABASE_PASSWORD = "0011000101011001011011010011000101110111010101100110110000110010011011000011001001001011010101100100011101000110";

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;

    static {
        config.setJdbcUrl(DATABASE_URL);
        config.setUsername(DATABASE_USER);
        config.setPassword(DATABASE_PASSWORD);

        // Opcjonalne ustawienia konfiguracji puli
        config.setMaximumPoolSize(10); // Maksymalna liczba połączeń w puli
        config.setMinimumIdle(2); // Minimalna liczba nieaktywnych połączeń
        config.setIdleTimeout(30000); // Czas bezczynności połączenia w milisekundach
        config.setConnectionTimeout(30000); // Maksymalny czas oczekiwania na połączenie w milisekundach
        config.setLeakDetectionThreshold(2000); // Czas wykrywania wycieków połączeń

        dataSource = new HikariDataSource(config);
    }

    /**
     * Returns a connection from the connection pool.
     * 
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("Failed to get connection from pool: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Closes the connection pool when the application is shutting down.
     */
    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("Connection pool closed.");
        }
    }
}
