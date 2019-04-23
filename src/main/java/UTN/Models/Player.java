package UTN.Models;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player extends Thread{
    private Word word;
    private int lives;
    private Set<Character> playedChars = new HashSet<>();

    public Player(Word word, int lives) {
        this.word = word;
        this.lives = lives;
    }

    public Player(Word word) {
        this.word = word;
    }

    @Override
    public void run(){
        while (lives > 0){ //and the returned win bool
            word.play(this.getChar());
        }
    }

    private char getChar(){
        Boolean a = false;
        Character c = null;
        Random r;

        while (!a){
            r = new Random();
            c = (char)(r.nextInt(26) + 'a');
            a = playedChars.add(c);
        }

        return c;
    }


}
