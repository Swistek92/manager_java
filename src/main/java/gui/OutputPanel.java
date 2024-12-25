package gui;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private JTextArea outputArea;
    private JList<String> studentList;
    private DefaultListModel<String> listModel;

    public OutputPanel() {
        setLayout(new BorderLayout());

        // Obszar wyjściowy
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.NORTH);

        // Lista studentów
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(studentList);
        add(listScrollPane, BorderLayout.CENTER);
    }

    // Metoda do dodawania 
    public void appendMessage(String message) {
        outputArea.insert(message + "\n", 0);
        outputArea.setCaretPosition(0); 

    }

    // Metoda do czyszczenia obszaru wyjściowego
    public void clearMessages() {
        outputArea.setText("");
    }

    // Metody dla listy studentów
    public JList<String> getStudentList() {
        return studentList;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }


}
