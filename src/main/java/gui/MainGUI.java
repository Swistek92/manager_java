package gui;

import model.Student;
import service.StudentController;
import service.StudentManagerImpl;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainGUI extends JFrame {
    private InputPanel inputPanel;
    private ButtonPanel buttonPanel;
    private OutputPanel outputPanel;
    private StudentManagerImpl studentManager;
    private StudentController studentController;

    public MainGUI() {
        setTitle("Student Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicjalizacja paneli
        inputPanel = new InputPanel();
        buttonPanel = new ButtonPanel();
        outputPanel = new OutputPanel();
        studentManager = new StudentManagerImpl(); // Inicjalizacja menedżera studentów
        studentController = new StudentController(studentManager, outputPanel); // Inicjalizacja kontrolera studentów

        // Ustawienie rozmiarów paneli
        inputPanel.setPreferredSize(new Dimension(800, 150));
        buttonPanel.setPreferredSize(new Dimension(800, 100));
        outputPanel.setPreferredSize(new Dimension(800, 350));

        // Dodanie paneli do głównego okna
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        // Przykład komunikatu w obszarze wyjściowym
        outputPanel.appendMessage("Welcome to Student Management System!\n");

        // Obsługa zdarzeń dla przycisków
        buttonPanel.getAddButton().addActionListener(e -> {
            addStudent();
            displayStudents();
        });
        buttonPanel.getRemoveButton().addActionListener(e -> {
            removeStudent();
            displayStudents();
        });
        buttonPanel.getUpdateButton().addActionListener(e -> {
            updateStudent();
            displayStudents();
        });
        buttonPanel.getDisplayButton().addActionListener(e -> displayStudents());
        buttonPanel.getAverageButton().addActionListener(e -> calculateAverageGrade());

        // Dodanie nasłuchiwacza dla wyboru z listy studentów
        outputPanel.getStudentList().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedValue = outputPanel.getStudentList().getSelectedValue();
                if (selectedValue != null) {
                    fillFormWithStudentData(selectedValue);
                }
            }
        });

        // Wywołanie metody wyświetlania studentów po uruchomieniu aplikacji
        displayStudents();
    }

    private void addStudent() {
        studentController.addStudent(
            inputPanel.getStudentIdField().getText(),
            inputPanel.getNameField().getText(),
            inputPanel.getAgeField().getText(),
            inputPanel.getGradeField().getText()
        );
    }

    private void removeStudent() {
        studentController.removeStudent(inputPanel.getStudentIdField().getText());
    }

    private void updateStudent() {
        studentController.updateStudent(
            inputPanel.getStudentIdField().getText(),
            inputPanel.getNameField().getText(),
            inputPanel.getAgeField().getText(),
            inputPanel.getGradeField().getText()
        );
    }

    private void displayStudents() {
        List<Student> students = studentManager.getAllStudents();
        outputPanel.getListModel().clear(); // Wyczyść listę przed dodaniem nowych danych
        if (students.isEmpty()) {
            outputPanel.appendMessage("No students to display.\n");
        } else {
            for (Student student : students) {
                String studentData = student.getStudentID() + ": " + student.getName() + ", Age=" + student.getAge() + ", Grade=" + student.getGrade();
                outputPanel.getListModel().addElement(studentData);
            }
        }
    }

    private void calculateAverageGrade() {
        double average = studentManager.calculateAverageGrade();
        outputPanel.appendMessage("Average grade: " + average + "\n");
    }

    private void fillFormWithStudentData(String studentData) {
        // Przykład parsowania: "S001: John Doe, Age=20, Grade=85.5"
        String[] parts = studentData.split(", ");
        String id = parts[0].split(": ")[0];
        String name = parts[0].split(": ")[1];
        String age = parts[1].split("=")[1];
        String grade = parts[2].split("=")[1];

        inputPanel.getStudentIdField().setText(id);
        inputPanel.getNameField().setText(name);
        inputPanel.getAgeField().setText(age);
        inputPanel.getGradeField().setText(grade);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}
