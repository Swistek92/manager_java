package gui;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private JTextArea outputArea;

    public OutputPanel() {
        setLayout(new BorderLayout());

        // Obszar wyjściowy
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Metoda do dodawania wiadomości
    public void appendMessage(String message) {
        outputArea.append(message + "\n");
    }

    // Metoda do czyszczenia obszaru wyjściowego
    public void clearMessages() {
        outputArea.setText("");
    }
}
