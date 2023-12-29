package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public static List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringJoiner delim = new StringJoiner("|", "[", "]");
        for (String s : delimiters) {
            delim.add(s);
        }
        return Arrays.asList(source.split(delim.toString()));
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("d");
        s.add("c");
        s.add(")");

        splitByDelimiters("", s);
    }
}
