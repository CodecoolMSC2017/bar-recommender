package com.codecool;

public class Question {

    String id;
    String questions;
    Answer answer;


    public Question(String id, String questions, Answer answer){
        this.id = id;
        this.questions = questions;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }


    public String getQuestions() {
        return questions;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean getEvaulatedAnswer(String input){
        boolean response = answer.evaulateAnswerByInput(input);
        return response;
    }
    
}
