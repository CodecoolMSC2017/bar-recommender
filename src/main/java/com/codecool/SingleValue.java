package com.codecool;

public class SingleValue extends Value {

    public SingleValue(String param, boolean selectionType) {
        super.setSelectionType(selectionType);
        super.getInputPattern().add(param);

    }


}
