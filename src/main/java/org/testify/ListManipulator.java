package org.testify;

import java.util.List;

public class ListManipulator {
    public int getListSize(List<String> list) {
        return list.size();
    }

    public boolean isListEmpty(List<String> list) {
        return list.isEmpty();
    }

    public String getElementAtIndex(List<String> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return list.get(index);
    }

    public void addElement(List<String> list, String element) {
        list.add(element);
    }
}

