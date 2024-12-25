package model;

public class Student {

    private String studentID; // Unikalny identyfikator studenta
    private String name;      // Imię studenta
    private int age;          // Wiek studenta
    private double grade;     // Ocena studenta

    /**
     * Konstruktor do inicjalizacji obiektu studenta.
     * @param studentID Unikalny identyfikator studenta
     * @param name Imię studenta
     * @param age Wiek studenta
     * @param grade Ocena studenta
     */
    public Student(String studentID, String name, int age, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Gettery i settery

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be positive.");
        }
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0.0 && grade <= 100.0) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Grade must be between 0.0 and 100.0.");
        }
    }

    /**
     * Wyświetla informacje o studencie w czytelnym formacie.
     */
    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}
