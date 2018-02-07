package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {
    private FactRepository testFactRepository;
    private Iterator<Fact> testFactIterator;


    @BeforeEach
    void setUp(){
        testFactRepository = new FactRepository();
        testFactIterator = testFactRepository.getIterator();
    }

    @Test
    void hasNextIsFalse() {
        assertFalse(testFactIterator.hasNext());
    }

    @Test
    void hasNextIsTrue() {
        testFactRepository.addFact(new Fact("id", "description"));
        assertTrue(testFactIterator.hasNext());
    }

    @Test
    void nextThrowsException(){
        try{
            testFactIterator.next();
        }
        catch (Exception e){
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    void nextIsTrue(){
        testFactRepository.addFact(new Fact("secondId", "SecondDescription"));
        assertEquals("SecondDescription", testFactIterator.next().getDesription());

    }
}