package controller.FileController;

import java.io.File;

public class Ex3_SetWorkingDir {

    public static String workingDir;

    /**
     * Sets the working directory to the specified path.
     * @param path The path to set as the working directory.
     */
    public static void setWorkingDir(String path) {
        File dir = new File(path);
        if (!dir.isDirectory()) {
            System.err.println("Error: The provided path is not a directory.");
            return;
        }

        workingDir = dir.getAbsolutePath();
        System.out.println("Working directory set to: " + workingDir);
    }
}