package controller.TextController;

import java.io.File;
import java.util.Scanner;

public class Ex1_ReadWords {
    /**
     * Main method to read words from a file.
     * @param f The file to read from.
     */
    public static void readWords(File f) {
        try {
            Scanner reader = new Scanner(f);

            while (reader.hasNext()) {
                System.out.println(reader.next());
            }
            reader.close();

        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
