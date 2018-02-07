package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {

    private Iterator<Question> iterator;
    private RuleRepository repo;

    @BeforeEach
    void setUp() {
        repo = new RuleRepository();
        iterator = repo.getIterator();
    }

    @Test
    void hasNext() {
        assertFalse(iterator.hasNext());
        repo.addQuestion(new Question("test1", "testQuestion1", new Answer()));
        assertTrue(iterator.hasNext());
    }

    @Test
    void next() {
        Question question1 = new Question("test1", "testQuestion1", new Answer());
        Question question2 = new Question("test2", "testQuestion2", new Answer());
        repo.addQuestion(question1);
        repo.addQuestion(question2);
        assertEquals(iterator.next(), question1);
        assertEquals(iterator.next(), question2);
    }
}