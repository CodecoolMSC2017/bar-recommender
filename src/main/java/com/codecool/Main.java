package com.codecool;

import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        ESProvider esProvider = new ESProvider(new FactParser(), new RuleParser());
        Fact fact;
        Iterator factIterator = esProvider.getFactRepository().getIterator();
        while (factIterator.hasNext()) {
            fact = (Fact) factIterator.next();
            System.out.println(fact.getDesription());
        }
        Question question;
        Iterator questionIterator = esProvider.getRuleRepository().getIterator();
        while (questionIterator.hasNext()) {
            question = (Question) questionIterator.next();
            System.out.println(question.getId());
            System.out.println(question.getQuestion());
        }
    }
}
