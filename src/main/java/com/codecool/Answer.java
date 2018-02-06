package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    List<Value> values = new ArrayList<Value>();

    public boolean evaulateAnswerByInput(String input){ // incomplete!
        for (int i = 0; i < values.size(); i++){
            if (values.get(i).getInputPattern().contains(input)){
                return true;
            }
        }
        return false;

    }

    public void addValue(Value value){
        values.add(value);
    }

}
