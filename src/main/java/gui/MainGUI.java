package gui;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private InputPanel inputPanel;
    private ButtonPanel buttonPanel;
    private OutputPanel outputPanel;

    public MainGUI() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicjalizacja paneli
        inputPanel = new InputPanel();
        buttonPanel = new ButtonPanel();
        outputPanel = new OutputPanel();

        // Ustawienie rozmiarów paneli
        inputPanel.setPreferredSize(new Dimension(800, 150)); // Mniejszy panel wejściowy
        buttonPanel.setPreferredSize(new Dimension(800, 100)); // Mniejszy panel przycisków
        outputPanel.setPreferredSize(new Dimension(800, 350)); // Większy panel wyjściowy

        // Dodanie paneli do głównego okna
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        // Przykład komunikatu w obszarze wyjściowym
        outputPanel.appendMessage("Welcome to Student Management System!");

        // Obsługa zdarzeń dla przycisków
        buttonPanel.getAddButton().addActionListener(e -> {
            String studentId = inputPanel.getStudentIdField().getText();
            String name = inputPanel.getNameField().getText();
            String ageText = inputPanel.getAgeField().getText();
            String gradeText = inputPanel.getGradeField().getText();

            try {
                int age = Integer.parseInt(ageText);
                double grade = Double.parseDouble(gradeText);
                // Wywołaj metodę z klasy StudentManagerImpl (przykład)
                outputPanel.appendMessage("Student added: ID=" + studentId + ", Name=" + name + "\n");
            } catch (NumberFormatException ex) {
                outputPanel.appendMessage("Error: Invalid age or grade format.\n");
            }
        });

        buttonPanel.getRemoveButton().addActionListener(e -> outputPanel.appendMessage("Remove student not implemented yet\n"));
        buttonPanel.getUpdateButton().addActionListener(e -> outputPanel.appendMessage("Update student not implemented yet\n"));
        buttonPanel.getDisplayButton().addActionListener(e -> outputPanel.appendMessage("Display all students not implemented yet\n"));
        buttonPanel.getAverageButton().addActionListener(e -> outputPanel.appendMessage("Calculate average grade not implemented yet\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}
