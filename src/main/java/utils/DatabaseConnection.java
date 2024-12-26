package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

//   Ładowanie zmiennych z pliku .env
    private static final Dotenv dotenv = Dotenv.load(); 
    private static final String DATABASE_URL = dotenv.get("DATABASE_URL");
    private static final String DATABASE_USER = dotenv.get("DATABASE_USER");
    private static final String DATABASE_PASSWORD = dotenv.get("DATABASE_PASSWORD");

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;

    static {
        try {
            // Ustawienia konfiguracji HikariCP
            config.setJdbcUrl(DATABASE_URL);
            config.setUsername(DATABASE_USER);
            config.setPassword(DATABASE_PASSWORD);

            // Opcjonalne ustawienia puli połączeń
            config.setMaximumPoolSize(10); // Maksymalna liczba połączeń w puli
            config.setMinimumIdle(2); // Minimalna liczba nieaktywnych połączeń
            config.setIdleTimeout(30000); // Czas bezczynności połączenia w milisekundach
            config.setConnectionTimeout(30000); // Maksymalny czas oczekiwania na połączenie w milisekundach
            config.setLeakDetectionThreshold(2000); // Czas wykrywania wycieków połączeń

            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize connection pool: " + e.getMessage(), e);
        }
    }

    /**
     * Zwraca połączenie z puli połączeń.
     *
     * @return Obiekt Connection
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
     * Zamyka pulę połączeń przy zamykaniu aplikacji.
     */
    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("Connection pool closed.");
        }
    }
}
