package org.testify;

public class StringManipulator {
    public String concatenate(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        return str1 + str2;
    }

    public String toUpperCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return str.toUpperCase();
    }

    public int stringLength(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return str.length();
    }
}

