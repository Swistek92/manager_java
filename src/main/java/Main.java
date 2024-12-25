import gui.MainGUI;
import utils.DatabaseConnection;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {
  
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });

        // Dodanie hooka do zamknięcia puli połączeń przy zamykaniu aplikacji
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            DatabaseConnection.closePool();
            System.out.println("Connection pool closed.");
        }));
    }
}
