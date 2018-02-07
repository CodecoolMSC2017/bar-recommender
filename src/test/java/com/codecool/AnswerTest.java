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
            assertEquals(e.getMessage(), "Wrong input");
        }
    }

    @Test
    void checkIfAnswerNo() {
        try {
            assertFalse(test.evaluateAnswerByInput(no));
        }
        catch (Exception e){
            assertEquals(e.getMessage(), "Wrong input");
        }
    }
    @Test
    void checkIfAnswerWrong() {
        try {
            assertTrue(test.evaluateAnswerByInput(exception));
        }
        catch (Exception e){
            assertEquals(e.getMessage(), "Wrong input");
        }
    }
}