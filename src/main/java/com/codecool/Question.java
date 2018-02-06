package com.codecool;

public class Question {

    private String id;
    private String questions;
    private Answer answer;


    public Question(String id, String questions, Answer answer) {
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

    public boolean getEvaulatedAnswer(String input) {
        return answer.evaluateAnswerByInput(input);
    }

}
