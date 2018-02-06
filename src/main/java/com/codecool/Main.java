package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        ESProvider esProvider = new ESProvider(new FactParser(), new RuleParser());

        ArrayList<Boolean> answers = new ArrayList<Boolean>();
        Question question;
        Iterator questionIterator = esProvider.getRuleRepository().getIterator();
        while (questionIterator.hasNext()) {
            question = (Question) questionIterator.next();
            answers.add(esProvider.getAnswerByQuestion(question.getId()));
        }
        esProvider.collectAnswers(answers);
    }
}
