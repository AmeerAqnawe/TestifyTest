package org.testify;

public class StringManipulator {

    /**
     * Concatenates two strings.
     *
     * @param str1 the first string to concatenate
     * @param str2 the second string to concatenate
     * @return the concatenated string
     * @throws IllegalArgumentException if either input string is null
     */
    public String concatenate(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        return str1 + str2;
    }

    /**
     * Converts a string to uppercase.
     *
     * @param str the string to convert
     * @return the uppercase version of the string
     * @throws IllegalArgumentException if the input string is null
     */
    public String toUpperCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return str.toUpperCase();
    }

    /**
     * Returns the length of a string.
     *
     * @param str the string whose length is to be measured
     * @return the length of the string
     * @throws IllegalArgumentException if the input string is null
     */
    public int stringLength(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return str.length();
    }

    /**
     * Finds the longest substring without repeating characters.
     *
     * @param str the string to examine
     * @return the longest substring without repeating characters
     * @throws IllegalArgumentException if the input string is null
     */
    public String longestSubstringWithoutRepeatingCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        int n = str.length();
        String output = "";
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < n; j++) {
                String currentChar = String.valueOf(str.charAt(j));
                if (temp.toString().contains(currentChar)) {
                    break;
                } else {
                    temp.append(currentChar);
                }
            }
            if (temp.length() > output.length()) {
                output = temp.toString();
            }
        }
        return output;
    }

    /**
     * Counts occurrences of a substring within a given string, both case-sensitive and case-insensitive.
     *
     * This method demonstrates duplicate code and excessive method length, which are considered code smells.
     *
     * @param str The string to search in.
     * @param substr The substring to search for.
     * @return A formatted string indicating the counts for both case-sensitive and case-insensitive matches.
     * @throws IllegalArgumentException if either input string or substring is null.
     */
    public String countSubstringOccurrences(String str, String substr) {
        if (str == null || substr == null) {
            throw new IllegalArgumentException("Neither the string nor the substring can be null");
        }

        // Case-sensitive count
        int countSensitive = 0;
        int index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            countSensitive++;
            index++;
        }

        // Case-insensitive count - Duplicate code with slight modification
        int countInsensitive = 0;
        index = 0;
        String lowerStr = str.toLowerCase();
        String lowerSubstr = substr.toLowerCase();
        while ((index = lowerStr.indexOf(lowerSubstr, index)) != -1) {
            countInsensitive++;
            index++;
        }

        // The method is longer than necessary due to duplicated logic
        return String.format("Case-sensitive count: %d, Case-insensitive count: %d", countSensitive, countInsensitive);
    }

}
