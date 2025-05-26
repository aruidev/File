package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static controller.FileController.Ex3_SetWorkingDir.workingDir;
import static java.lang.Integer.parseInt;

public class Controller {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        do {
            System.out.println("Welcome to the File and Text Operations Controller!");
            handleMenu();
        } while (true);
    }

    public static void handleMenu() {
        System.out.println("1. File Operations");
        System.out.println("2. Text Operations");
        System.out.println("0. Exit");

        switch (parseInt(scanner.nextLine())) {
            case 1:
                handleFileMenu();
                break;
            case 2:
                handleTextMenu();
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                handleMenu();
                break;
        }
        System.out.println();
    }

    public static void handleFileMenu() {
        System.out.println("File Operations Menu:");
        System.out.println("1. Get Item Information");
        System.out.println("2. Get Path Information");
        System.out.println("3. Set Working Directory");
        System.out.println("4. List, Create, or Move Items");
        System.out.println("5. Create a List of Items");
        System.out.println("6. Copy an Item with Apache Commons");
        System.out.println("0. Back to Main Menu");
        System.out.println();

        switch (parseInt(scanner.nextLine())) {
            case 1:
                controller.FileController.Ex1_GetItemInfo.displayDetailedInfo(new File(workingDir));
            case 2:
                controller.FileController.Ex2_GetPathInfo.displayPathInfo(new File(workingDir));
                break;
            case 3:
                System.out.println("Enter the new working directory path:");
                String newPath = scanner.nextLine();
                controller.FileController.Ex3_SetWorkingDir.setWorkingDir(newPath);
                break;
            case 4:
                handleListCreateMoveMenu();
                break;
            case 5:
                System.out.println("Enter the directory path of the new items (enter 0 to exit):");
                String dirPath = scanner.nextLine();
                ArrayList<String> items = new ArrayList<>();
                while (!dirPath.equals("0")) {
                    dirPath = scanner.nextLine();
                    items.add(dirPath);
                    if (dirPath.equals("0")) {
                        break;
                    }
                }
                controller.FileController.Ex5_CreateListOfItems.createListOfItems(items.toArray(new String[0]));
                break;
            case 6:
                System.out.println("Enter the source file path:");
                String sourcePath = scanner.nextLine();
                System.out.println("Enter the destination file path:");
                String destPath = scanner.nextLine();
                controller.FileController.Ex6_CopyItemWithApacheCommons.copyItem(sourcePath, destPath);
                break;
            case 0:
                System.out.println("Returning to main menu...");
                handleMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                handleFileMenu();
                break;
        }
        System.out.println();
    }

    public static void handleListCreateMoveMenu() {
        System.out.println("List, Create, or Move Items Menu:");
        System.out.println("1. List Directory Contents");
        System.out.println("2. Create Item (File/Directory)");
        System.out.println("3. Move Item");
        System.out.println("0. Back to File Operations Menu");
        System.out.println();

        switch (parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Enter the directory path to list:");
                String listPath = scanner.nextLine();
                controller.FileController.Ex4_ListCreateMoveItem.listDir(new File(listPath));
                break;
            case 2:
                System.out.println("Enter the path of the item to create:");
                String createPath = scanner.nextLine();
                controller.FileController.Ex4_ListCreateMoveItem.createItem(createPath);
                break;
            case 3:
                System.out.println("Enter the source path of the item to move:");
                String sourcePath = scanner.nextLine();
                System.out.println("Enter the destination path for the item:");
                String destPath = scanner.nextLine();
                controller.FileController.Ex4_ListCreateMoveItem.moveItem(sourcePath, destPath);
                break;
            case 0:
                handleFileMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                handleListCreateMoveMenu();
                break;
        }
        System.out.println();
    }

    public static void handleTextMenu() {
        System.out.println("Text Operations Menu:");
        System.out.println("1. Read Words from File");
        System.out.println("2. Save Words in Array");
        System.out.println("3. Read Numbers from File");
        System.out.println("4. Read Fields from a CSV File");
        System.out.println("5. Get Types of Strings in a File");
        System.out.println("6. Generate Users in a File");
        System.out.println("7. Generate Grades in a File");
        System.out.println("0. Back to Main Menu");

        switch (parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Reading file...");
                controller.TextController.Ex1_ReadWords.readWords(new File("src/files/ex1-2.txt"));
                break;
            case 2:
                System.out.println("Reading file...");
                controller.TextController.Ex2_FileToArray.fileToArray(new File("src/files/ex1-2.txt"));
                break;
            case 3:
                System.out.println("Reading file...");
                controller.TextController.Ex3_ReadNums.readNumbersFromFile(new File("src/files/ex3.txt"));
                break;
            case 4:
                System.out.println("Reading file...");
                controller.TextController.Ex4_ReadCSV.readCSV(new File("src/files/ex4.csv"));
                break;
            case 5:
                System.out.println("Reading file...");
                controller.TextController.Ex5_ReadTypes.getType("src/files/ex5.txt");
                break;
            case 6:
                System.out.println("Generating file...");
                controller.TextController.Ex6_GenerateUsers.GenerateUsers("src/files/ex6.txt");
                break;
            case 7:
                System.out.println("Generating file...");
                controller.TextController.Ex7_Grades.generateGrades(new File("src/files/grades.txt"));
                break;
            case 0:
                handleMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                handleTextMenu();
                break;
        }
    }
}
