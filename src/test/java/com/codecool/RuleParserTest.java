package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    private RuleParser parser;

    @BeforeEach
    void setUp() {
        parser = new RuleParser("./src/main/rules.xml");
    }

    @Test
    void nullCheck() {
        RuleRepository repo = parser.getRuleRepository();
        assertNotEquals(repo, null);
    }
}