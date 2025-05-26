package controller.FileController;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Ex1_GetItemInfo {
    /**
     * Main method to display information about a file or directory.
     * @param f The file or directory to display information for.
     */
    public static void displayDetailedInfo(File f) {
        try {
            System.out.println("Canonical path: " + f.getCanonicalPath());
        } catch (Exception e) {
            System.err.println("Error al obtenir la ruta canònica: " + e);
            return;
        }
        System.out.println("Directory:      " + f.isDirectory());
        System.out.println("Hidden:         " + f.isHidden());
        System.out.println("Read:           " + f.canRead());
        System.out.println("Write:          " + f.canWrite());
        System.out.println("Execute:        " + f.canExecute());
        System.out.println("Length:         " + f.length());
        Date d = new Date(f.lastModified());
        System.out.println("LastModified:   " + d.toString());
    }

    static String getDateSize(File f) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(f.lastModified());

        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DAY_OF_MONTH);
        int hh = c.get(Calendar.HOUR);
        int mm = c.get(Calendar.MINUTE);

        return String.format("%02d/%02d/%04d %02d/%02d %12d", d, m, y, hh, mm, f.length());
    }

    static String getDateSize(String p) {
        File f = new File(p);

        if (f.exists()) return getDateSize(f);
        else return "??/??/???? ??/??            ?";
    }
}
