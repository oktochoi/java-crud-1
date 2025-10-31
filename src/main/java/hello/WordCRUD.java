package hello;

import java.util.*;
import java.io.*;

public class WordCRUD implements ICRUD {
    private ArrayList<Word> wordList = new ArrayList<>();
    private int nextId = 1;
    private final String filename = "words.txt";
    private Scanner sc;

    public WordCRUD(Scanner sc) {
        this.sc = sc;
        loadFromFile();
    }

    @Override
    public void add() {
        System.out.print("Enter new word: ");
        String word = sc.nextLine();
        System.out.print("Enter meaning: ");
        String meaning = sc.nextLine();
        System.out.print("Enter level (1~3): ");
        int level = Integer.parseInt(sc.nextLine());

        wordList.add(new Word(nextId++, level, word, meaning));
        System.out.println("=> Word added successfully!");
    }

    @Override
    public void list() {
        for (Word w : wordList) {
            System.out.println(w);
        }
    }

    @Override
    public void list(int level) {
        for (Word w : wordList) {
            if (w.getLevel() == level)
                System.out.println(w);
        }
    }

    @Override
    public void search(String keyword) {
        for (Word w : wordList) {
            if (w.getWord().contains(keyword))
                System.out.println(w);
        }
    }

    @Override
    public void update(int id) {
        for (Word w : wordList) {
            if (w.getId() == id) {
                System.out.print("Enter new word: ");
                w.setWord(sc.nextLine());
                System.out.print("Enter new meaning: ");
                w.setMeaning(sc.nextLine());
                System.out.print("Enter new level (1~3): ");
                w.setLevel(Integer.parseInt(sc.nextLine()));
                System.out.println("=> Word updated successfully!");
                return;
            }
        }
        System.out.println("=> Word not found!");
    }

    @Override
    public void delete(int id) {
        wordList.removeIf(w -> w.getId() == id);
        System.out.println("=> Word deleted successfully!");
    }

    @Override
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Word w : wordList)
                pw.println(w.toFileString());
            System.out.println("=> Words have been saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    int level = Integer.parseInt(data[1]);
                    String word = data[2];
                    String meaning = data[3];
                    wordList.add(new Word(id, level, word, meaning));
                    nextId = Math.max(nextId, id + 1);
                }
            }
        } catch (IOException ignored) {}
    }
}
