package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {
    private Iterator<Question> iterator;
    private List<Question> list = new ArrayList<Question>();

    public void addQuestion(Question question) {
        list.add(question);
    }

    public Iterator<Question> getIterator() {
        iterator = new QuestionIterator(list);
        return iterator;
    }
}
