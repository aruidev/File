package controller.FileController;

import java.io.File;

public class Ex4_ListCreateMoveItem {
    /**
     * Lists the contents of a directory.
     * @param f The file or directory to list.
     */
    public static void listDir(File f) {
        if (f.isDirectory()) {
            String[] files = f.list();

            if (files == null) {
                System.out.println("The directory is empty or an error occurred.");
                return;
            } else {
                for (String file : files) {
                    System.out.println(file);
                }
            }
        } else {
            System.out.println(f.getName() + " is not a directory.");
        }
    }

    /**
     * Creates a file or directory at the specified path.
     * @param path The path where the file or directory should be created.
     */
    public static void createItem(String path) {
        try {
            File f = new File(path);
            if (f.isDirectory()) {
                if (f.mkdirs()) {
                    System.out.println("Directory created at: " + f.getAbsolutePath());
                } else {
                    System.out.println("Directory already exists at: " + f.getAbsolutePath());
                }
            }
            if (f.isFile()) {
                if (f.createNewFile()) {
                    System.out.println("File created at: " + f.getAbsolutePath());
                } else {
                    System.out.println("File already exists at: " + f.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.err.println("Error creating file or directory: " + e.getMessage());
        }
    }

    /**
     * Moves a file or directory from the source path to the destination path.
     * @param sourcePath The path of the file or directory to move.
     * @param destPath   The destination path where the file or directory should be moved.
     */
    public static void moveItem(String sourcePath, String destPath) {
        try {
            File source = new File(sourcePath);
            File dest = new File(destPath);

            if (!source.exists()) {
                System.out.println("Source file or directory does not exist: " + sourcePath);
                return;
            }

            if (source.renameTo(dest)) {
                System.out.println("Moved " + source.getName() + " to " + dest.getAbsolutePath());
            } else {
                System.out.println("Failed to move " + source.getName() + " to " + dest.getAbsolutePath());
            }

        } catch (Exception e) {
            System.err.println("Error moving item: " + e.getMessage());
        }
    }
}
