package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class FactParser extends XMLParser {

    FactRepository repo = new FactRepository();

    void loadXmlDocument(String xmlPath) {
        DocumentBuilder DBuilder = null;
        Document doc = null;
        try {
            DBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = DBuilder.parse(new File(xmlPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        NodeList nodeList = doc.getElementsByTagName("Fact");
        Fact fact;
        String id;
        String description;
        boolean hair;
        boolean shirt;
        boolean shit;
        boolean cat;
        boolean shoes;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            id = element.getAttribute("id");
            NodeList childs = element.getChildNodes();

            Element desc = (Element) childs.item(1);
            description = desc.getAttribute("value");
            Element evals = (Element) childs.item(3);

            hair = Boolean.parseBoolean(evals.getElementsByTagName("hair").item(0).getTextContent());
            shirt = Boolean.parseBoolean(evals.getElementsByTagName("shirt").item(0).getTextContent());
            shit = Boolean.parseBoolean(evals.getElementsByTagName("shit").item(0).getTextContent());
            cat = Boolean.parseBoolean(evals.getElementsByTagName("cat").item(0).getTextContent());
            shoes = Boolean.parseBoolean(evals.getElementsByTagName("shoes").item(0).getTextContent());

            fact = new Fact(id, description);
            fact.setFactValueById("hair", hair);
            fact.setFactValueById("shirt", shirt);
            fact.setFactValueById("shit", shit);
            fact.setFactValueById("cat", cat);
            fact.setFactValueById("shoes", shoes);
            repo.addFact(fact);
        }

    }

    public FactRepository getFactRepository() {
        return repo;
    }
}
