package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {

    public List<Fact> list = new ArrayList<Fact>();

    public void addFact(Fact fact) {
        list.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator(list);
    }
}
