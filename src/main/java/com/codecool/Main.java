package com.codecool;

public class Main {
    public static void main(String[] args){
        ESProvider esProvider = new ESProvider(new FactParser(), new RuleParser());

        esProvider.collectAnswers();
    }
}
