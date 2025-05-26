package controller.TextController;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Ex6_GenerateUsers {
    /**
     * Generates a list of users with IDs, names, and surnames and writes them to a specified file.
     * @param filePath The path to the file where the users will be written.
     */
    public static void GenerateUsers(String filePath) {
        final ArrayList<String> NAMES = new ArrayList<>(List.of(
                "Carlos Alberto", "Ana Belén", "Ana Maria", "María",
                "Victoria Federica", "Julio César", "María Jesús",
                "Marco Antonio", "Luis Miguel", "Fernando",
                "Verónica", "Jesús", "Francisco Javier"
        ));

        final ArrayList<String> SURNAMES = new ArrayList<>(List.of(
                "Morales", "Caçador", "del Moral", "Díaz",
                "López Contreras", "Smith", "de la Fuente",
                "Castro Pérez", "Williams", "Tàpies",
                "Martí Agell", "Caño", "Fernández Colomer", "García Merino"
        ));

        final ArrayList<Integer> IDS = new ArrayList<>();

        for (int i = 0; i < NAMES.size(); ++i) {
            int id = i + 1;
            IDS.add(id);
        }

        try {
            PrintStream writer = new PrintStream(filePath);

            for (int i = 0; i < NAMES.size(); ++i) {
                String name = NAMES.get(i);
                String surname = SURNAMES.get(i);
                int id = IDS.get(i);

                writer.println("ID: " + id + ", Name: " + name + ", Surname: " + surname);
            }
            writer.close();
            System.out.println("Users generated successfully in " + filePath);
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
