package service;

import model.Student;
import java.util.List;

public interface StudentManager {

    /**
     * Dodaje nowego studenta do bazy danych.
     * @param student Obiekt reprezentujący studenta.
     */
    void addStudent(Student student);

    /**
     * Usuwa studenta na podstawie unikalnego ID.
     * @param studentID Unikalny identyfikator studenta.
     */
    void removeStudent(String studentID);

    /**
     * Aktualizuje dane istniejącego studenta.
     * @param student Obiekt studenta z zaktualizowanymi danymi.
     */
    void updateStudent(Student student);

    /**
     * Pobiera listę wszystkich studentów z bazy danych.
     * @return Lista studentów.
     */
    List<Student> getAllStudents();

    /**
     * Oblicza średnią ocenę wszystkich studentów.
     * @return Średnia ocen.
     */
    double calculateAverageGrade();
}
