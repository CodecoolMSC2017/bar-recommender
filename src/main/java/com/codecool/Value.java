package com.codecool;

import java.util.List;

abstract class Value {
    List<String> values;

    public Value(List<String> values) {
        this.values = values;
    }

    public Value(){}

    public List<String> getInputPattern(){
        return values;
    }


}
