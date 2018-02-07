package com.codecool;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    private Answer test = new Answer();

    @Test
    void checkIfAnswerYes() {
        try {
            String yes = "yes";
            assertTrue(test.evaluateAnswerByInput(yes));
        } catch (Exception e) {
            assertEquals("No exception expected, but get one", e.getMessage());
        }
    }

    @Test
    void checkIfAnswerNo() {
        try {
            String no = "no";
            assertFalse(test.evaluateAnswerByInput(no));
        } catch (Exception e) {
            assertEquals("No exception expected, but get one", e.getMessage());
        }
    }

    @Test
    void checkIfAnswerWrong() {
        try {
            String exception = "asda";
            test.evaluateAnswerByInput(exception);
        } catch (Exception e) {
            assertEquals("Wrong input", e.getMessage());
        }
    }
}