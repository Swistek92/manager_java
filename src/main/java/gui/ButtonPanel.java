package gui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton addButton, removeButton, updateButton, displayButton, averageButton;

    public ButtonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Ustawienie BoxLayout w osi poziomej

        // Inicjalizacja przycisków z ustaloną wysokością
        addButton = createButton("Add Student");
        removeButton = createButton("Remove Student");
        updateButton = createButton("Update Student");
        displayButton = createButton("Display All");
        averageButton = createButton("Calculate Avg");

        // Dodanie przycisków do panelu z odstępami
        add(createButtonPanel(addButton));
        add(createButtonPanel(removeButton));
        add(createButtonPanel(updateButton));
        add(createButtonPanel(displayButton));
        add(createButtonPanel(averageButton));
    }

    // Metoda pomocnicza do tworzenia przycisku z ustalonym rozmiarem
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 50)); // Ustawienie preferowanego rozmiaru
        return button;
    }

    // Metoda pomocnicza do tworzenia panelu opakowującego przycisk
    private JPanel createButtonPanel(JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(button);
        return panel;
    }

    // Gettery dla przycisków
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDisplayButton() {
        return displayButton;
    }

    public JButton getAverageButton() {
        return averageButton;
    }
}
