package com.codecool;

import java.util.ArrayList;
import java.util.List;

abstract class Value {
    List<String> valuesList = new ArrayList<String>();

    public Value(List<String> values) {
        this.valuesList = values;
    }

    public Value() {
    }

    public List<String> getInputPattern() {
        return valuesList;
    }


}
