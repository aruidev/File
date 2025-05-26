package controller.TextController;

import java.io.File;
import java.util.Scanner;

public class Ex5_ReadTypes {
    /**
     * Main method to read types from a file.
     * @param f The file to read from.
     */
    public static void displayTypes(File f) {
        try {
            Scanner reader = new Scanner(f);

            while (reader.hasNext()) {
                String word = reader.next();
                System.out.println(getType(word));
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e);
        }
    }

    public static String getType(String s) {
        if (s.matches("-?\\d+")) {
            return s + " is an Integer";
        } else if (s.matches("-?\\d+\\.\\d+")) {
            return s + " is a Float";
        } else if (s.matches("-?\\d+\\.\\d+E-?\\d+")) {
            return s + " is a Scientific Notation";
        } else {
            return s + " is a String";
        }
    }
}
