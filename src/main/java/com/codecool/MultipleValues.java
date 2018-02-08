package com.codecool;

import java.util.List;

public class MultipleValues extends Value {

    public MultipleValues(List<String> param, boolean selectionType) {
        setSelectionType(selectionType);
        for(String value : param) {
            super.getInputPattern().add(value);
        }
    }


}
