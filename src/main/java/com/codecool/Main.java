package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        ESProvider esProvider = new ESProvider(new FactParser(), new RuleParser());

        esProvider.collectAnswers();
        System.out.println(esProvider.evaluate());
    }
}
