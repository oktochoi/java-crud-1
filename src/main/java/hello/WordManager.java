package hello;

import java.util.*;

public class WordManager {
    private Scanner sc = new Scanner(System.in);
    private WordCRUD wordCRUD = new WordCRUD(sc);

    public void run() {
        while (true) {
            System.out.println("\n[English Word Manager]");
            System.out.println("1. List  2. List(level)  3. Search");
            System.out.println("4. Add   5. Modify       6. Delete");
            System.out.println("7. Save file  0. Exit");
            System.out.print("Select menu: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> wordCRUD.list();
                case 2 -> {
                    System.out.print("Enter level (1~3): ");
                    int level = Integer.parseInt(sc.nextLine());
                    wordCRUD.list(level);
                }
                case 3 -> {
                    System.out.print("Enter keyword: ");
                    wordCRUD.search(sc.nextLine());
                }
                case 4 -> wordCRUD.add();
                case 5 -> {
                    System.out.print("Enter ID to modify: ");
                    wordCRUD.update(Integer.parseInt(sc.nextLine()));
                }
                case 6 -> {
                    System.out.print("Enter ID to delete: ");
                    wordCRUD.delete(Integer.parseInt(sc.nextLine()));
                }
                case 7 -> wordCRUD.saveToFile();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid menu.");
            }
        }
    }

    public static void main(String[] args) {
        new WordManager().run();
    }
}
