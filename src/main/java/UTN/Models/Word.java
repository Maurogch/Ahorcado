package UTN.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word {
    private String playedWord;
    private boolean win;
    private boolean playing = false;
    private boolean gameEnded = false;
    private List<Character> correctChars = new ArrayList<>();
    private Set<Character> playedChars = new HashSet<>();

    public Word(String playedWord) {
        this.playedWord = playedWord;
    }

    public synchronized boolean play(char playedChar){
        while (playing){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(gameEnded) return false; //This was necessary as both players would win otherwise, ask why
        //Why was the other thread entering if the game ended was true after the noftify

        playing = true;

        if(playedWord.indexOf(playedChar) >= 0)
            correctChars.add(playedChar);

        if (playedWord.length() == correctChars.size()) {
            win = true;
            gameEnded = true;
        }

        playing = false;

        notify();

        return win;
    }

    public synchronized Set<Character> getPlayedChars() {
        return playedChars;
    }

    public synchronized void setPlayedChars(Set<Character> playedChars) {
        this.playedChars = playedChars;
    }

    public String getPlayedWord() {
        return playedWord;
    }

    public boolean gameEnded() {
        return gameEnded;
    }
}
