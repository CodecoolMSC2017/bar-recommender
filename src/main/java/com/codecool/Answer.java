package com.codecool;

import java.util.List;

public class Answer {
    List<Value> answers;

    public boolean evaulateAnswerByInput(String input){ // incomplete!
        if(input.toLowerCase().equals("true")){
            return true;
        }
        else{
            return false;
        }

    }

    public void addValue(Value value){
        answers.add(value);
    }

}
