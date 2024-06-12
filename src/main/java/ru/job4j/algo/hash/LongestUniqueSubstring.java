package ru.job4j.algo.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    public static String longestUniqueSubstring(String str) {
        var maxSubstring = new StringBuilder();
        var currentString = new StringBuilder();
        Set<Character> uniqueSubstringSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            currentString.append(c);
            if (uniqueSubstringSet.contains(c)) {
                currentString = new StringBuilder(String.valueOf(c));
                uniqueSubstringSet.clear();
                uniqueSubstringSet.add(c);
            } else {
                uniqueSubstringSet.add(c);
                maxSubstring = currentString.length() > maxSubstring.length()
                        ? new StringBuilder(currentString) : maxSubstring;
            }
        }
        return maxSubstring.toString();
    }
}
