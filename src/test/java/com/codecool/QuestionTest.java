package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    private Answer answer = new Answer();
    private Question testQuestion;

    @BeforeEach
    void setUp() {
        String id = "newID";
        String question = "isThereID?";
        answer.addValue(new SingleValue("newValue", true));
        testQuestion = new Question(id, question, answer);
    }

    @Test
    void testGetId() {
        assertEquals("newID", testQuestion.getId());
    }

    @Test
    void testGetQuestion() {
        assertEquals("isThereID?", testQuestion.getQuestion());
    }

    @Test
    void testGetAnswer() {
        assertTrue(testQuestion.getAnswer().equals(answer));
    }

    @Test
    void testGetEvaulatedAnswer() {
        try {
            String yes = "yes";
            assertTrue(testQuestion.getEvaulatedAnswer(yes));
        } catch (Exception e) {
            assertEquals("no excpetion expected, but got one", e.getMessage());
        }
    }
}