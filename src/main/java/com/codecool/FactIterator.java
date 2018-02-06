package com.codecool;


import org.w3c.dom.*;


import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator {

    private int i;
    private List<Fact> list;

    public FactIterator(List<Fact> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (i + 1 < list.size()) {
            return true;
        }
        return false;
    }

    public Fact next() {
        Fact fact = list.get(i);
        i++;
        return fact;
    }

    public void remove() {

    }
}
