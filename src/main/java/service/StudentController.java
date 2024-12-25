package service;

import model.Student;
import utils.Validators;
import gui.OutputPanel;

public class StudentController {
    private StudentManagerImpl studentManager;
    private OutputPanel outputPanel;

    public StudentController(StudentManagerImpl studentManager, OutputPanel outputPanel) {
        this.studentManager = studentManager;
        this.outputPanel = outputPanel;
    }

    public void addStudent(String studentId, String name, String ageText, String gradeText) {
        if (Validators.validateStudentInput(studentId, name, ageText, gradeText, outputPanel)) {
            Student student = new Student(studentId, name, Integer.parseInt(ageText), Double.parseDouble(gradeText));
            studentManager.addStudent(student);
            outputPanel.appendMessage("Student added: " + student.getName());
        }
    }

    public void removeStudent(String studentId) {
        if (studentId.isEmpty()) {
            outputPanel.appendMessage("Error: Please enter a student ID to remove.");
            return;
        }

        Student student = studentManager.getStudentById(studentId);
        if (Validators.validateStudentExists(student, outputPanel)) {
            studentManager.removeStudent(studentId);
            outputPanel.appendMessage("Student removed: ID=" + studentId);
        }
    }

    public void updateStudent(String studentId, String name, String ageText, String gradeText) {
        if (Validators.validateStudentInput(studentId, name, ageText, gradeText, outputPanel)) {
            Student student = new Student(studentId, name, Integer.parseInt(ageText), Double.parseDouble(gradeText));
            Student existingStudent = studentManager.getStudentById(studentId);
            if (Validators.validateStudentExists(existingStudent, outputPanel)) {
                studentManager.updateStudent(student);
                outputPanel.appendMessage("Student updated: " + student.getName());
            }
        }
    }
}
