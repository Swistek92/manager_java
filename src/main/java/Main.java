import utils.DatabaseConnection;
import gui.MainGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Ustanowienie połączenia z bazą danych
        DatabaseConnection.connect();

        // Uruchomienie GUI w wątku Event Dispatch Thread (Swing wymaga tego dla poprawnego działania GUI)
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });

        // Dodanie hooka do zamknięcia połączenia z bazą przy zakończeniu działania aplikacji
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            DatabaseConnection.close();
            System.out.println("Database connection closed.");
        }));
    }
}
