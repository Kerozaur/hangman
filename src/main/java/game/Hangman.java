package game;

import javax.swing.*;
import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        String[] words = new String[2];
        words[0] = "Keyboard";
        words[1] = "Mousepads";

        double index = Math.random();
        int zaindex = (int) (index * 2);

        String word = words[zaindex];
        int limit = 5;


        int mistakes = 0;
        boolean guessed = false;
        Set<Character> allLetters = new HashSet<>();
        Set<Character> guessedLetters = new HashSet<>();

        for (int i = 0 ; i < word.length() ; i++) {
            allLetters.add(word.charAt(i));
        }
        for (int i = 0 ; i <word.length() ; i++) {
            System.out.print("- ");
        }
        System.out.println();
        System.out.println();

        while (mistakes <= 5 && !(guessed)) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            char guess = input.charAt(0);
            if (allLetters.contains(guess)) {
             guessedLetters.add(guess);
            }
            else {mistakes++;}
            for (int i = 0 ; i < word.length() ; i++) {
                if (guessedLetters.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i));
                }
                else {System.out.print("-");}
                System.out.print(" ");
            }
            guessed = guessedLetters.equals(allLetters);
            System.out.println();
            System.out.println();
        }
        if (guessed) {
            System.out.println("You did it! YEY!");
        }
        else {System.out.println("YOU SUCK!");}
    }
}
