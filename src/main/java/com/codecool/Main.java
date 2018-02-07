package com.codecool;

public class Main {
    public static void main(String[] args){
        String rootDir = args[0];
        ESProvider esProvider = new ESProvider(new FactParser( rootDir + "/facts.xml"), new RuleParser(rootDir + "/rules.xml"));

        esProvider.collectAnswers();
    }
}
