package com.codecool;

import java.util.Iterator;

public class Main {
    public static void main(String[] args){
        ESProvider esProvider = new ESProvider(new FactParser(), new RuleParser());
        Fact fact;
        System.out.println(esProvider.getFactRepository().list);
        Iterator factIterator = esProvider.getFactRepository().getIterator();
        while (factIterator.hasNext()) {
            fact = (Fact) factIterator.next();
            System.out.println(fact.getDesription());
        }
    }
}
