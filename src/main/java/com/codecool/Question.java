package com.codecool;

public class Question {

    private String id;
    private String question;
    private Answer answer;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        System.out.println(question);

    }

    public String getId() {
        return id;
    }


    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean getEvaulatedAnswer(String input) throws Exception {
        return answer.evaluateAnswerByInput(input);
    }

}
