package UTN.Models;

public class Word {
    private String playedWord;
    private boolean win;
    private boolean playing;

    public synchronized boolean play(char playedChar){
        while (playing){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            playing = true;

            //todo play game

            playing = false;
            notify();
        }

        return win;
    }
}
