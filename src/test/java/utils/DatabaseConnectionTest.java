package utils;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void testGetConnection() {
        // Testuje, czy połączenie jest prawidłowe
        try (Connection connection = DatabaseConnection.getConnection()) {
            assertNotNull(connection, "Connection should not be null.");
            assertTrue(connection.isValid(2), "Connection should be valid.");
        } catch (SQLException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    void testConnectionPoolSettings() {
        // Testuje ustawienia puli połączeń
        assertDoesNotThrow(() -> {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(System.getenv("DATABASE_URL"));
            config.setUsername(System.getenv("DATABASE_USER"));
            config.setPassword(System.getenv("DATABASE_PASSWORD"));
        }, "Pool settings should not throw an exception.");
    }

    @AfterAll
    static void tearDown() {
        // Testuje zamknięcie puli połączeń
        assertDoesNotThrow(DatabaseConnection::closePool, "Closing pool should not throw an exception.");
    }
}
