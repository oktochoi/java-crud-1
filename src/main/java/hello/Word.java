package hello;

public class Word {
    private int id;
    private int level;
    private String word;
    private String meaning;

    public Word(int id, int level, String word, String meaning) {
        this.id = id;   
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() { return id; }
    public int getLevel() { return level; }
    public String getWord() { return word; }
    public String getMeaning() { return meaning; }

    public void setLevel(int level) { this.level = level; }
    public void setWord(String word) { this.word = word; }
    public void setMeaning(String meaning) { this.meaning = meaning; }

    @Override
    public String toString() {
        return String.format("%d [%d] %s : %s", id, level, word, meaning);
    }

    public String toFileString() {
        return String.format("%d|%d|%s|%s", id, level, word, meaning);
    }
}
