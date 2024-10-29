package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var anagram = new Anagram();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter 1 to check if two strings are anagrams, and 2 to find all anagrams of a string. Enter 0 to exit.");
                var feature = scanner.nextLine();
                switch (feature) {
                    case "1":
                        System.out.println("Enter the first string:");
                        final var firstWord = scanner.nextLine();
                        System.out.println("Enter the second string:");
                        final var secondWord = scanner.nextLine();
                        if (anagram.areAnagrams(firstWord, secondWord)) {
                            System.out.println("The two strings are anagrams.");
                        } else {
                            System.out.println("The two strings are not anagrams.");
                        }
                        break;
                    case "2":
                        System.out.println("Enter the string:");
                        final var word = scanner.nextLine();
                        final var anagrams = anagram.findAnagrams(word);
                        if (anagrams.isEmpty()) {
                            System.out.println("No anagrams found.");
                        } else {
                            System.out.println("The anagrams of the string are:");
                            anagrams.forEach(System.out::println);
                        }
                        break;
                    case "0":
                        System.out.println("Bye!");
                        return;
                    default:
                        System.out.println("Invalid feature number. Please try again.");
                }
            }
        }
    }
}