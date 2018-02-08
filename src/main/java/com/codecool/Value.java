package com.codecool;

import java.util.ArrayList;
import java.util.List;

abstract class Value {
    private List<String> valuesList = new ArrayList<String>();
    private boolean selectionType;


    public void setSelectionType(boolean selectionType) {
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return valuesList;
    }


    public boolean getSelectionType() {
        return selectionType;
    }


}
