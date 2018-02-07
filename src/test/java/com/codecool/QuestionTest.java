package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Answer answer = new Answer();
    String question;
    String id;
    String yes = "yes";
    Question testQuestion;

    @BeforeEach
    void setUp() {
        id = "newID";
        question = "isThereID?";
        answer.addValue(new SingleValue("newValue"));
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
            assertTrue(testQuestion.getEvaulatedAnswer(yes));
        }
        catch (Exception e){
            assertEquals("no excpetion expected, but got one", e.getMessage());
        }
    }
}