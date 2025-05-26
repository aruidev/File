package controller.TextController;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex2_FileToArray {
    /**
     * Reads a file and returns its content as an ArrayList of strings.
     * @param f The file to read.
     * @return An ArrayList containing the words from the file, or null if an error occurs.
     */
    public static ArrayList<String> fileToArray(File f) {
        try {
            Scanner reader = new Scanner(f);
            ArrayList<String> words = new ArrayList<>();

            while (reader.hasNext()) {
                String word = reader.next();
                words.add(word);
            }
            reader.close();
            return words;

        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    /**
     * Displays the content of an ArrayList of strings to the console.
     * @param words The ArrayList containing words to display.
     */
    public static void displayFileToArray(ArrayList <String> words) {;
        if (words == null || words.isEmpty()) {
            System.out.println("No words found or error reading file.");
            return;
        }

        System.out.println("Printing words in the file:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
