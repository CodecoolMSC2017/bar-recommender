package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;


public class RuleParser extends XMLParser {
    private RuleRepository repo = new RuleRepository();


    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath);
    }

    public RuleRepository getRuleRepository() {
        return repo;
    }


    public void loadXmlDocument(String xmlPath) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            doc = dbBuilder.parse(new File(xmlPath));
        } catch (Exception o) {
            o.printStackTrace();
        }
        String id;
        String question;
        Question quest;
        Answer answer = null;

        NodeList nodes = doc.getElementsByTagName("Rule");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element;
            element = (Element) nodes.item(i);
            id = element.getAttribute("id");
            NodeList nodeList = element.getChildNodes();
            question = nodeList.item(1).getTextContent();
            NodeList answersList = nodeList.item(3).getChildNodes();
            answer = new Answer();
            for(int j=1; j<=3; j+=2) {
                String param = ( (Element) answersList.item(j)).getAttribute("value");
                boolean selectionType = Boolean.parseBoolean(((Element) answersList.item(j)).getNodeName());
                String type = ((Element) answersList.item(j).getChildNodes().item(1)).getNodeName();
                if(type.equals("SingleValue")) {
                    answer.addValue(new SingleValue(param, selectionType));
                } else if(type.equals("MultipleValue")){
                    answer.addValue(new MultipleValues(Arrays.asList(param.split(",")),selectionType));
                }
            }
            quest = new Question(id, question, answer);
            repo.addQuestion(quest);
        }
    }
}
