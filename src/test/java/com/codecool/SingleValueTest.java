package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SingleValueTest {
    Value testSingleValue;
    List<String> localTest;

    @BeforeEach
    void setUp() {
        testSingleValue = new SingleValue("test", true);
        localTest = new ArrayList<String>();
        localTest.add("test");
    }

    @Test
    void getInputPattern() {
        assertEquals(localTest, testSingleValue.getInputPattern());
    }
}