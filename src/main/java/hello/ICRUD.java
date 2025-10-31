package hello;

import java.util.*;

public interface ICRUD {
    void add();
    void list();
    void list(int level);
    void search(String keyword);
    void update(int id);
    void delete(int id);
    void saveToFile();
    void loadFromFile();
}
