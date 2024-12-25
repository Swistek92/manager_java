package service;

import gui.OutputPanel;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import utils.Validators;

import static org.mockito.Mockito.*;

class StudentControllerTest {

    private StudentManagerImpl studentManagerMock;
    private OutputPanel outputPanelMock;
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        studentManagerMock = mock(StudentManagerImpl.class); // Mock obiektu StudentManagerImpl
        outputPanelMock = mock(OutputPanel.class);           // Mock obiektu OutputPanel
        studentController = new StudentController(studentManagerMock, outputPanelMock);
    }

    @Test
    void testAddStudent_ValidInput() {
        // Arrange
        String studentId = "S001";
        String name = "John Doe";
        String ageText = "20";
        String gradeText = "85.5";

        // Mockowanie walidatora statycznego
        try (MockedStatic<Validators> validatorsMock = Mockito.mockStatic(Validators.class)) {
            validatorsMock.when(() -> Validators.validateStudentInput(studentId, name, ageText, gradeText, outputPanelMock))
                    .thenReturn(true);

            // Act
            studentController.addStudent(studentId, name, ageText, gradeText);

            // Assert
            verify(studentManagerMock).addStudent(any(Student.class));
            verify(outputPanelMock).appendMessage(contains("Student added: " + name));
        }
    }
}
