package utils;

import gui.OutputPanel;
import utils.Validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    private OutputPanel outputPanel;

    @BeforeEach
    void setUp() {
        outputPanel = new OutputPanel();
    }

    @Test
    void testValidateStudentInput_ValidInput() {
        boolean isValid = Validators.validateStudentInput("S001", "John Doe", "20", "85.5", outputPanel);
        assertTrue(isValid, "Valid input should pass validation.");
    }

    @Test
    void testValidateStudentInput_InvalidAge() {
        boolean isValid = Validators.validateStudentInput("S001", "John Doe", "-1", "85.5", outputPanel);
        assertFalse(isValid, "Negative age should fail validation.");
    }

    @Test
    void testValidateStudentInput_InvalidGrade() {
        boolean isValid = Validators.validateStudentInput("S001", "John Doe", "20", "110", outputPanel);
        assertFalse(isValid, "Grade above 100 should fail validation.");
    }

    @Test
    void testValidateStudentExists() {
        boolean exists = Validators.validateStudentExists(null, outputPanel);
        assertFalse(exists, "Non-existing student should fail validation.");
    }
}
