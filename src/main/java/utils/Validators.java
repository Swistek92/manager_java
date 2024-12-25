package utils;

import model.Student;
import gui.OutputPanel;

public class Validators {

    /**
     * Validates the input fields for adding or updating a student and logs errors to the OutputPanel.
     *
     * @param studentId the student's ID
     * @param name the student's name
     * @param ageText the student's age as text
     * @param gradeText the student's grade as text
     * @param outputPanel the OutputPanel to log errors
     * @return true if validation passes, false otherwise
     */
    public static boolean validateStudentInput(String studentId, String name, String ageText, String gradeText, OutputPanel outputPanel) {
        boolean isValid = true;

        if (studentId == null || studentId.isEmpty()) {
            outputPanel.appendMessage("Error: Student ID cannot be empty.");
            isValid = false;
        }
        if (name == null || name.isEmpty()) {
            outputPanel.appendMessage("Error: Name cannot be empty.");
            isValid = false;
        }
        try {
            int age = Integer.parseInt(ageText);
            if (age <= 0) {
                outputPanel.appendMessage("Error: Age must be a positive integer.");
                isValid = false;
            }
        } catch (NumberFormatException e) {
            outputPanel.appendMessage("Error: Age must be a valid number.");
            isValid = false;
        }
        try {
            double grade = Double.parseDouble(gradeText);
            if (grade < 0.0 || grade > 100.0) {
                outputPanel.appendMessage("Error: Grade must be between 0 and 100.");
                isValid = false;
            }
        } catch (NumberFormatException e) {
            outputPanel.appendMessage("Error: Grade must be a valid number.");
            isValid = false;
        }

        return isValid;
    }

    /**
     * Validates if a student exists in the database and logs errors to the OutputPanel.
     *
     * @param student the student object
     * @param outputPanel the OutputPanel to log errors
     * @return true if the student exists, false otherwise
     */
    public static boolean validateStudentExists(Student student, OutputPanel outputPanel) {
        if (student == null) {
            outputPanel.appendMessage("Error: The specified student does not exist.");
            return false;
        }
        return true;
    }

    /**
     * Validates if the database operation was successful and logs errors to the OutputPanel.
     *
     * @param rowsAffected the number of rows affected by the database operation
     * @param outputPanel the OutputPanel to log errors
     * @return true if rows were affected, false otherwise
     */
    public static boolean validateDatabaseOperation(int rowsAffected, OutputPanel outputPanel) {
        if (rowsAffected == 0) {
            outputPanel.appendMessage("Error: The database operation did not affect any rows.");
            return false;
        }
        return true;
    }
}
