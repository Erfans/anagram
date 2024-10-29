package com.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Anagram class to check if two strings are anagrams and find all anagrams of a string.
 */
public class Anagram {

    /**
     * The key is generated by createKey function, and the value is a list of anagrams of the key.
     *
     * @see Anagram:createKey
     */
    final static Map<String, Set<String>> anagrams = new HashMap<>();

    /**
     * Checks if two strings are anagrams.
     *
     * @return true if the two strings are anagrams, false otherwise
     */
    public boolean areAnagrams(final String firstWord, final String secondWord) {
        if (firstWord == null || secondWord == null || firstWord.isEmpty() || secondWord.isEmpty()) {
            return false;
        }

        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        final var firstWordKey = createKey(firstWord);
        final var secondWordKey = createKey(secondWord);
        if (firstWordKey.equals(secondWordKey)) {
            anagrams.computeIfAbsent(firstWordKey, k -> new HashSet<>()).addAll(List.of(firstWord, secondWord));

            return true;
        }

        return false;
    }

    /**
     * Finds all anagrams of a word.
     *
     * @return a set of anagrams of the word (excluding the given word)
     */
    public Set<String> findAnagrams(final String word) {
        return anagrams.getOrDefault(createKey(word), Set.of())
                .stream()
                .filter(w -> !w.equals(word))
                .collect(Collectors.toSet());
    }

    /**
     * Lowercase and sort the characters in a word.
     * Considering anagram is case-insensitive.
     *
     * @return the sorted word
     */
    private String createKey(final String word) {
        final var chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}