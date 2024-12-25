package utils;

public class SQLQueries {

    // Query do dodania studenta
    private static final String INSERT_STUDENT = "INSERT INTO students (studentID, name, age, grade) VALUES (?, ?, ?, ?)";

    // Query do usunięcia studenta na podstawie ID
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE studentID = ?";

    // Query do aktualizacji danych studenta
    private static final String UPDATE_STUDENT = "UPDATE students SET name = ?, age = ?, grade = ? WHERE studentID = ?";

    // Query do pobrania wszystkich studentów
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";

    // Query do obliczenia średniej ocen studentów
    private static final String CALCULATE_AVERAGE_GRADE = "SELECT AVG(grade) AS averageGrade FROM students";

    // Gettery dla zapytań

    public static String getInsertStudentQuery() {
        return INSERT_STUDENT;
    } 

    public static String getDeleteStudentQuery() {
        return DELETE_STUDENT;
    }

    public static String getUpdateStudentQuery() {
        return UPDATE_STUDENT;
    }

    public static String getSelectAllStudentsQuery() {
        return SELECT_ALL_STUDENTS;
    }

    public static String getCalculateAverageGradeQuery() {
        return CALCULATE_AVERAGE_GRADE;
    }
}
