package UTN.Models;

import java.time.LocalDate;

public class Winner {
    private String name;
    private String word;
    private LocalDate date;

    public Winner(String name, String word) {
        this.name = name;
        this.word = word;
        date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getWord() {
        return word;
    }

    public LocalDate getDate() {
        return date;
    }
}
