package UTN.Models;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Player extends Thread{
    private String playerName;
    private Word word;
    private int lives;
    private Boolean win;


    public Player(Word word, int lives, String name) {
        this.word = word;
        this.lives = lives;
        this.playerName = name;
        win = false;
    }

    @Override
    public void run(){
        while (lives > 0 && !word.gameEnded()){
            try {
                char playedChar = getChar();
                sleep(10);
                win = word.play(playedChar);
                if(word.gameEnded() || win) break;
                synchronized (this) {
                    String letters = word.getCorrectChars().stream()
                            .map( n -> n.toString() )
                            .collect( Collectors.joining( "," ) );
                    System.out.println(playerName + " guessed with character: " + playedChar
                    + "\n Guessed letters: " + letters + "\n");
                }
                lives--;
            } catch (NullPointerException e) {
                System.out.println("Error: No more letters to play");
                System.exit(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(lives == 0){
            word.setGameEnded(true); //if a player dies, the other wins, stop playing
            System.out.println("\n" + playerName + " has lost the game, correct word was -" + word.getPlayedWord() + "-");
        }

        if(win){
            System.out.println("\n" + playerName + " has won the game, correct word was -" + word.getPlayedWord() + "-");
            System.out.println("Total number of tries : " + word.getPlayedChars().size());
        }
    }

    //Gets list of played chars from word, then returns a char not yet played
    private char getChar(){
        boolean notPlayed = false;
        Character c = null;
        Random r;
        char[] vocals = {'a', 'e', 'i', 'o', 'u'};
        Set<Character> playedChars = word.getPlayedChars();

        while (!notPlayed && playedChars.size() != 26){
            //Try to play with vocals first
            if(playedChars.size()<5) {
                c = vocals[playedChars.size()];
                notPlayed = playedChars.add(c);
            }

            //If all vocals played get a random char from the alphabet
            if(!notPlayed) {
                r = new Random();
                c = (char) (r.nextInt(26) + 'a');
                notPlayed = playedChars.add(c);
            }
        }

        word.setPlayedChars(playedChars);

        return c;
    }

    public Boolean getWin() {
        return win;
    }

    public String getPlayerName() {
        return playerName;
    }
}
