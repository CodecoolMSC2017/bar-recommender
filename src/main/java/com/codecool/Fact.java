package com.codecool;

import java.util.HashMap;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private HashMap values = new HashMap<String, Boolean>();

    public Fact(String id, String description) {
        this.description = description;
        this.id = id;
    }

    public Set<String> getIdSet() {
        return values.keySet();
    }

    public void setFactValueById(String id, boolean value) {
        values.put(id, value);
    }

    public boolean getValueById(String id) {
        return (Boolean) values.get(id);
    }

    public String getDesription() {
        return description;
    }
}
