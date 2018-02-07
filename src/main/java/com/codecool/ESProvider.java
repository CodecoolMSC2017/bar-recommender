package com.codecool;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private HashMap<String, Boolean> answers = new HashMap<String, Boolean>();

    public ESProvider(FactParser factParser, RuleParser ruleParser) {

        factParser.loadXmlDocument("src/main/facts.xml");
        ruleParser.loadXmlDocument("src/main/rules.xml");

        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }

    public void collectAnswers() {
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        int counter = 0;
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            this.answers.put(question.getId(), answers.get(counter));
            counter++;
        }
    }

    public boolean getAnswerByQuestion(String questionId) {
        Scanner userInput = new Scanner(System.in);
        Iterator<Question> iterator = ruleRepository.getIterator();
        while (iterator.hasNext()) {
            Question question = iterator.next();
            if (questionId.equals(question.getId())) {
                System.out.println(question.getQuestion());
                String answer;
                while (true) {
                    try {
                        answer = userInput.nextLine();
                        boolean result = question.getEvaulatedAnswer(answer);
                        return result;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public String evaluate() {
        HashMap<String, Integer> hasMap = getHashMapResult();
        String result = "";
        int max = 0;
        for (String name : hasMap.keySet()) {
            if (hasMap.get(name) > max) {
                max = hasMap.get(name);
                result = name;
            }
        }
        for (String name : hasMap.keySet()) {
            if (hasMap.get(name) == max && !(result.contains(name))) {
                result += ", " + name;
            }
        }
        return result;
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }

    private HashMap<String, Integer> getHashMapResult() {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        Iterator<Question> iterator = ruleRepository.getIterator();
        Iterator<Fact> factIt = factRepository.getIterator();
        int count = 0;
         while(factIt.hasNext()) {
             count = 0;
             Fact fact = factIt.next();
             for (String id : answers.keySet()) {
                if (fact.getValueById(id) == answers.get(id)){
                    count+=1;
                }
            }
            result.put(fact.getDesription(), count);


        }
           return result;
    }
}
