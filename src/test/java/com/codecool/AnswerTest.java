package com.codecool;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    Answer test = new Answer();
    String yes = "yes";
    String no = "no";
    String exception = "asda";

    @Test
    void checkIfAnswerYes() {
        try {
            assertTrue(test.evaluateAnswerByInput(yes));
        }
        catch (Exception e){
            assertEquals("No exception expected, but get one",e.getMessage());
        }
    }

    @Test
    void checkIfAnswerNo() {
        try {
            assertFalse(test.evaluateAnswerByInput(no));
        }
        catch (Exception e){
            assertEquals("No exception expected, but get one",e.getMessage());
        }
    }
    @Test
    void checkIfAnswerWrong() {
        try {
            test.evaluateAnswerByInput(exception);
        }
        catch (Exception e){
            assertEquals(e.getMessage(), "Wrong input");
        }
    }
}