-- Tworzenie bazy danych
CREATE DATABASE IF NOT EXISTS student_management;

-- Użycie bazy danych
USE student_management;

-- Tworzenie tabeli students
CREATE TABLE IF NOT EXISTS students (
    studentID VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT CHECK (age > 0),
    grade DOUBLE CHECK (grade >= 0.0 AND grade <= 100.0)
);

-- Wstawianie danych
INSERT INTO students (studentID, name, age, grade)
VALUES
('0001', 'Elliot Alderson', 27, 95.0),
('0002', 'Mr. Robot', 40, 85.0),
('0003', 'Darlene Alderson', 25, 88.0),
('0004', 'Angela Moss', 28, 92.5),
('0005', 'Tyrell Wellick', 30, 80.0),
('0006', 'Phillip Price', 55, 78.0),
('0007', 'Whiterose', 50, 99.0),
('0008', 'Joanna Wellick', 32, 85.0),
('0009', 'Shayla Nico', 26, 87.0),
('0010', 'Dominique DiPierro', 35, 90.0),
('0011', 'Leon', 30, 82.0),
('0012', 'Fernando Vera', 33, 70.0);
