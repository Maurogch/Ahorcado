package UTN.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word {
    private String playedWord;
    private boolean win;
    private boolean playing = false;
    private volatile boolean gameEnded = false;
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

        if(gameEnded) return false;

        playing = true;

        /*Deprecated, if the character appeared more than once, it would only add it once
        if(playedWord.indexOf(playedChar) >= 0)
            correctChars.add(playedChar);*/

        for (int i = 0; i < countOccurences(playedWord, playedChar, 0); i++) {
            correctChars.add(playedChar);
        }

        if (playedWord.length() == correctChars.size()) {
            win = true;
            gameEnded = true;
        }

        playing = false;

        notify();

        return win;
    }

    //Recursive method to count chars in a String
    private static int countOccurences(String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurences(someString, searchedChar, index + 1);
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

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public List<Character> getCorrectChars() {
        return correctChars;
    }
}
