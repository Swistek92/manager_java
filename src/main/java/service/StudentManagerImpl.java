package service;

import model.Student;
import utils.DatabaseConnection;
import utils.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagerImpl implements StudentManager {

    /**
     * Dodaje nowego studenta do bazy danych.
     * @param student Obiekt reprezentujący studenta.
     */
    @Override
    public void addStudent(Student student) {
        final String sql = SQLQueries.getInsertStudentQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getStudentID());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setDouble(4, student.getGrade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    /**
     * Usuwa studenta na podstawie unikalnego ID.
     * @param studentID Unikalny identyfikator studenta.
     */
    @Override
    public void removeStudent(String studentID) {
        final String sql = SQLQueries.getDeleteStudentQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error removing student: " + e.getMessage());
        }
    }

    /**
     * Aktualizuje dane istniejącego studenta.
     * @param student Obiekt studenta z zaktualizowanymi danymi.
     */
    @Override
    public void updateStudent(Student student) {
        final String sql = SQLQueries.getUpdateStudentQuery();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setDouble(3, student.getGrade());
            pstmt.setString(4, student.getStudentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    /**
     * Pobiera listę wszystkich studentów z bazy danych.
     * @return Lista studentów.
     */
    @Override
    public List<Student> getAllStudents() {
        final String sql = SQLQueries.getSelectAllStudentsQuery();
        List<Student> students = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String studentID = rs.getString("studentID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double grade = rs.getDouble("grade");
                students.add(new Student(studentID, name, age, grade));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }
        return students;
    }

    /**
     * Oblicza średnią ocenę wszystkich studentów.
     * @return Średnia ocen.
     */
    @Override
    public double calculateAverageGrade() {
        final String sql = SQLQueries.getCalculateAverageGradeQuery();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("averageGrade");
            }
        } catch (SQLException e) {
            System.err.println("Error calculating average grade: " + e.getMessage());
        }
        return 0.0;
    }

    /**
     * Pobiera studenta na podstawie jego ID.
     * @param studentId Unikalny identyfikator studenta.
     * @return Obiekt studenta lub null, jeśli nie znaleziono.
     */
    public Student getStudentById(String studentId) {
        final String sql = "SELECT * FROM students WHERE studentID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString("studentID");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    double grade = rs.getDouble("grade");
                    return new Student(id, name, age, grade);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student by ID: " + e.getMessage());
        }
        return null;
    }
}
