package controller.TextController;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex7_Grades {
    /**
     * Reads a file containing student grades and prints them to the console.
     * The file should have lines formatted as "Name;Subject;Grade".
     * @param f The file to read.
     */
    public static void generateGrades(File f) {
        try {
            Scanner reader = new Scanner(f);
            int rows = 0;

            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                ArrayList<String> fields = new ArrayList<>();

                if (row != null && !row.isEmpty()) {
                    for (String field : row.split(";")) {
                        fields.add(field.trim());
                    }
                }

                if (fields.size() >= 3) {
                    String name = fields.get(0);
                    String subject = fields.get(1);
                    String gradeStr = fields.get(2);

                    try {
                        double grade = Double.parseDouble(gradeStr);
                        System.out.printf("Student: %s, Subject: %s, Grade: %.2f%n", name, subject, grade);
                    } catch (NumberFormatException e) {
                        System.err.printf("Invalid grade for student %s in subject %s: %s%n", name, subject, gradeStr);
                    }

                    rows++;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
