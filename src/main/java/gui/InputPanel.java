package gui;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private JTextField studentIdField, nameField, ageField, gradeField;

    public InputPanel() {
        setLayout(new GridLayout(4, 2)); // Dostosowanie układu do 4 wierszy (bez przycisków)

        // Pola wejściowe
        add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        add(studentIdField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Grade:"));
        gradeField = new JTextField();
        add(gradeField);
    }

    // Gettery do komponentów
    public JTextField getStudentIdField() {
        return studentIdField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getGradeField() {
        return gradeField;
    }
}
