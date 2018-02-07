package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FactRepositoryTest {
    private FactRepository testFactRepository;

    @BeforeEach
    void setUp(){
        testFactRepository = new FactRepository();
    }

    @Test
    void testAddFact() {
        testFactRepository.addFact(new Fact("id", "description"));
        assertEquals(1, testFactRepository.list.size());
    }

    @Test
    void testGetIterator() {
        testFactRepository.addFact(new Fact("id", "description"));
        assertTrue(testFactRepository.getIterator().hasNext());
        assertEquals("description",testFactRepository.getIterator().next().getDesription());
    }

    @Test
    void testGetIteratorThrowException(){
        try{
            testFactRepository.getIterator().next();
        }
        catch (Exception e){
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }
}