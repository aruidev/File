package controller.TextController;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex3_ReadNums {
    /**
     * Reads integers from a file and stores them in an ArrayList.
     * * @param f The file to read from.
     */
    public static void readNumbersFromFile(File f) {
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner reader = new Scanner(f);

            while (reader.hasNext()) {
                if (reader.hasNextInt()) {
                    numbers.add(reader.nextInt());
                } else {
                    reader.next(); // Ignora el token no enter
                }
            }
            reader.close();

        } catch (Exception e) {
            System.err.println("Error reading file: " + e);
        }
    }

    /**
     * Reads integers from a file until a negative number is encountered,
     * @param f The file to read from.
     */
    public static void readNumbersFromFileUntilNegative(File f) {
        ArrayList<Integer> numbers2 = new ArrayList<>();
        try {
            Scanner reader = new Scanner(f);

            while (reader.hasNext()) {
                if (reader.hasNextInt()) {
                    int num = reader.nextInt();
                    if (num < 0) break; // Atura la lectura si el número és negatiu
                    numbers2.add(num);
                } else {
                    reader.next(); // Ignora el token no enter
                }
            }
            reader.close();

        } catch (Exception e) {
            System.err.println("Error reading file: " + e);
        }
    }
}
