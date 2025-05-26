package controller.TextController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex4_ReadCSV {

    /**
     * Reads the provided String and returns the fields as an ArrayList of Strings.
     * @param row The String to be processed, typically a line from a CSV file.
     * @return
     */
    public static ArrayList<String> readFields(String row, String sep) {
        ArrayList<String> fields = new ArrayList<>();

        if (sep == null || sep.isEmpty()) {
            sep = ";"; // Default separator
        }

        if (row != null && !row.isEmpty()) {
            for (String field : row.split(sep)) {
                fields.add(field.trim());
            }
        }

        return fields;
    }

    /**
     * Reads a CSV file and prints the player information.
     * @param f The File object representing the CSV file.
     */
    public static void readCSV(File f) {
        try {
            Scanner reader = new Scanner(f);
            int rows = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                ArrayList<String> fields = readFields(line, ";");

                if (fields.size() >= 3) {
                    System.out.println("Player " + (++rows) + ":");
                    System.out.println("  Name: " + fields.get(0));
                    System.out.println("  Date of birth: " + fields.get(1));
                    System.out.println("  Height: " + fields.get(2) + "m");
                    System.out.println();
                }
            }

            System.out.println("Total players: " + rows);
            reader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
