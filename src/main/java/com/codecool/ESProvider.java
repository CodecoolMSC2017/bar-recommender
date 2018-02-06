package com.codecool;

import java.util.Iterator;
import java.util.Scanner;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        factParser.loadXmlDocument("./src/main/facts.xml");
        ruleParser.loadXmlDocument("./src/main/rules.xml");
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }

    public void collectAnswers() {

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
        return null;
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}
