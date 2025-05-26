package controller.FileController;

import java.io.File;
import java.io.IOException;

public class Ex2_GetPathInfo {
    /**
     * Displays various path information for a given file.
     * @param f The file for which to display path information.
     */
    public static void displayPathInfo(File f) {
        System.out.println("Name:          " + f.getName());
        System.out.println("Parent:        " + f.getParent());
        System.out.println("Path:          " + f.getPath());
        System.out.println("AbsolutePath:  " + f.getAbsolutePath());
        try {
            System.out.println("CanonicalPath: " + f.getCanonicalPath());
        } catch (Exception e) {
            System.err.println("Error obtaining path: " + e.getMessage());
        }
    }
}
