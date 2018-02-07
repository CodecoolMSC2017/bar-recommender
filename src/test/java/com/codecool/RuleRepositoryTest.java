package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class RuleRepositoryTest {

    private RuleRepository repo;

    @BeforeEach
    void setUp() {
        repo = new RuleRepository();
    }

    @Test
    void getIterator() {
        assertFalse(repo.getIterator().hasNext());
        Question question = new Question("test", "testQuestion", new Answer());
        repo.addQuestion(question);
        assertTrue(repo.getIterator().hasNext());
        assertEquals(repo.getIterator().next(), question);
    }

    @Test
    void addQuestion() {
        Question question = new Question("test", "testQuestion", new Answer());
        repo.addQuestion(question);
        Question returnedQuestion = repo.getIterator().next();
        assertEquals(returnedQuestion, question);
        assertEquals(returnedQuestion.getId(), "test");
        assertEquals(returnedQuestion.getQuestion(), "testQuestion");
    }
}