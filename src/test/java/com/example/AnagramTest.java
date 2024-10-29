package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


class AnagramTest {

    Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }

    @Test
    void testAreAnagrams() {
        assertTrue(anagram.areAnagrams("listen", "silent"));
        assertTrue(anagram.areAnagrams("triangle", "integral"));

        assertFalse(anagram.areAnagrams("hello", "world"));
        assertFalse(anagram.areAnagrams("aa", "bb"));
    }

    @Test
    void testAreAnagrams_should_beCaseInsensitive() {
        assertTrue(anagram.areAnagrams("lisTEN", "SILent"));
        assertTrue(anagram.areAnagrams("triangle", "INTEGRAL"));
    }

    @Test
    void testAreAnagrams_should_beTrue_when_equals() {
        assertTrue(anagram.areAnagrams("listen", "listen"));
        assertTrue(anagram.areAnagrams("listen", "LISTEN"));
    }

    @Test
    void testAreAnagrams_should_beFalse_when_nullOrEmpty() {
        assertFalse(anagram.areAnagrams(null, null));
        assertFalse(anagram.areAnagrams("", ""));
        assertFalse(anagram.areAnagrams("", null));
    }

    @Test
    void testFindAnagrams() {
        // given
        anagram.areAnagrams("Erfan", "Faren");
        anagram.areAnagrams("Frane", "Fearn");
        anagram.areAnagrams("Nfera", "Anfre");
        anagram.areAnagrams("Rafen", "Nefra");
        anagram.areAnagrams("Nfare", "Afren");
        anagram.areAnagrams("Ranef", "Erfan");

        // when
        var anagrams = anagram.findAnagrams("Erfan");

        // then
        assertThat(anagrams).containsExactlyInAnyOrder("Faren", "Frane", "Nfera", "Rafen", "Nfare", "Ranef", "Afren", "Nefra", "Fearn", "Anfre");
    }
}