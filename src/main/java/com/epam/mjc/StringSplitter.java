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
        List<String> stringList = new ArrayList<>();
        StringJoiner delim = new StringJoiner("|", "[", "]");
        for (String s : delimiters) {
            delim.add(s);
        }

        for (String s: source.split(delim.toString())){
           if (!s.equals("")){
               stringList.add(s);
           }
        }
        return stringList;
    }
}
