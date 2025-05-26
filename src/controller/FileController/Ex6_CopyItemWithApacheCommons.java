package controller.FileController;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class Ex6_CopyItemWithApacheCommons {
    /**
     * Copies a file from sourcePath to destPath using Apache Commons IO.
     *
     * @param sourcePath the path of the source file
     * @param destPath   the path where the file should be copied
     */
    public static void copyItem(String sourcePath, String destPath) {
        try {
            File sourceFile = new File(sourcePath);
            File destFile = new File(destPath);
            FileUtils.copyFile(sourceFile, destFile);
            System.out.println("File copied from " + sourcePath + " to " + destPath);
        } catch (Exception e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
