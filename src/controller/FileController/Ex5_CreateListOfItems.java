package controller.FileController;

import java.io.File;
import java.io.IOException;

public class Ex5_CreateListOfItems {
    /**
     * Creates files at the specified paths. If a file already exists at a path,
     * it will not be overwritten.
     *
     * @param paths The paths where files should be created.
     */
    public static void createListOfItems(String... paths) {
        for (String path : paths) {
            File f = new File(path);
            try {
                if (f.createNewFile()) {
                    System.out.println("File created at: " + f.getAbsolutePath());
                } else {
                    System.out.println("File already exists at: " + f.getAbsolutePath());
                }
            } catch (Exception e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }
    }
}
