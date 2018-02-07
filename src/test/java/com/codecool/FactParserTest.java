package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {

    private FactParser testFactParser;

    @BeforeEach
    void setUp(){
        testFactParser = new FactParser("./src/main/facts.xml");
    }

    @Test
    void testLoadXml(){
        FactRepository factRepo = testFactParser.getFactRepository();
        assertNotEquals(null, factRepo);
    }

    @Test
    void testIfDataLoadedFromXml(){
        FactRepository validFact = testFactParser.getFactRepository();
        assertTrue(validFact.getIterator().hasNext());
        assertEquals("Kék Osztriga", validFact.getIterator().next().getDesription());
    }



}