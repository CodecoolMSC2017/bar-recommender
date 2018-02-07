package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;

public class FactParser extends XMLParser {

    FactRepository repo = new FactRepository();

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
    }

    void loadXmlDocument(String xmlPath) {
        DocumentBuilder DBuilder;
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

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            id = element.getAttribute("id");
            NodeList childs = element.getChildNodes();

            Element desc = (Element) childs.item(1);
            description = desc.getAttribute("value");
            Element evals = (Element) childs.item(3);

            NodeList conditions = evals.getChildNodes();
            HashMap<String, Boolean> values = new HashMap<String, Boolean>();
            int counter = 1;
            while (counter < conditions.getLength()) {
                Node item = conditions.item(counter);
                values.put(item.getNodeName(), Boolean.parseBoolean(item.getTextContent()));
                counter += 2;
            }

            fact = new Fact(id, description);
            for (String itemName : values.keySet()) {
                fact.setFactValueById(itemName, values.get(itemName));
            }
            repo.addFact(fact);
        }

    }

    public FactRepository getFactRepository() {
        return repo;
    }
}
