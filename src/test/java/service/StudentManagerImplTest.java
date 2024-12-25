package service;

import model.Student;
import service.StudentManagerImpl;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerImplTest {

    private final StudentManagerImpl manager = new StudentManagerImpl();

    @Test
    void testAddStudent() {
        // Arrange
        Student student = new Student("S001", "John Doe", 20, 85.5);

        // Act
        manager.addStudent(student);
        Student retrieved = manager.getStudentById("S001");

        // Assert
        assertNotNull(retrieved, "Student should be added and retrievable.");
        assertEquals("John Doe", retrieved.getName(), "Student name should match.");
    }

    @Test
    void testRemoveStudent() {
        // Arrange
        Student student = new Student("S002", "Jane Smith", 22, 90.0);
        manager.addStudent(student);

        // Act
        manager.removeStudent("S002");
        Student retrieved = manager.getStudentById("S002");

        // Assert
        assertNull(retrieved, "Student should be removed.");
    }

    @Test
    void testUpdateStudent() {
        // Arrange
        Student student = new Student("S003", "Mark Lee", 21, 75.0);
        manager.addStudent(student);

        // Act
        Student updatedStudent = new Student("S003", "Mark Updated", 23, 88.5);
        manager.updateStudent(updatedStudent);
        Student retrieved = manager.getStudentById("S003");

        // Assert
        assertNotNull(retrieved, "Updated student should exist.");
        assertEquals("Mark Updated", retrieved.getName(), "Student name should be updated.");
        assertEquals(23, retrieved.getAge(), "Student age should be updated.");
        assertEquals(88.5, retrieved.getGrade(), "Student grade should be updated.");
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        manager.addStudent(new Student("S004", "Alice", 20, 82.5));
        manager.addStudent(new Student("S005", "Bob", 22, 88.0));

        // Act
        List<Student> students = manager.getAllStudents();

        // Assert
        assertTrue(students.size() >= 2, "At least 2 students should be present.");
    }
}
