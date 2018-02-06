package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Value> values = new ArrayList<Value>();

    public boolean evaluateAnswerByInput(String input) throws Exception {
        input = input.toLowerCase();
        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        }
        throw new Exception("Wrong input");
    }

    public void addValue(Value value) {
        values.add(value);
    }

}
