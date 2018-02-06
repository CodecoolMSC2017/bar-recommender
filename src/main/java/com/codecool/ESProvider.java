package com.codecool;

public class ESProvider {

    private FactRepository factRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        factParser.loadXmlDocument("./src/main/facts.xml");
        this.factRepository = factParser.getFactRepository();
    }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {
        return true;
    }

    public String evaluate() {
        return null;
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }
}
