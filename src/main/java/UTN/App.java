package UTN;

import UTN.Database.WinnerDAO;
import UTN.Database.WordDAO;
import UTN.Models.Player;
import UTN.Models.Winner;
import UTN.Models.Word;

import static java.lang.Thread.sleep;

public class App 
{
    public static void main( String[] args )
    {
        WordDAO wordDAO = new WordDAO();
        WinnerDAO winnerDAO = new WinnerDAO();
        Winner winner;

        Word word = new Word(wordDAO.getWord());
        Player p1 = new Player(word, 12, "Player 1");
        Player p2 = new Player(word, 12, "Player 2");

        /* Not necessary
        /*Thread tPlayer1 = new Thread(p1);
        Thread tPlayer2 = new Thread(p2);

        tPlayer1.start();
        tPlayer2.start();*/

        System.out.println(
                "   _____  .__                                     .___      \n" +
                "  /  _  \\ |  |__   ___________   ____ _____     __| _/____  \n" +
                " /  /_\\  \\|  |  \\ /  _ \\_  __ \\_/ ___\\\\__  \\   / __ |/  _ \\ \n" +
                "/    |    \\   Y  (  <_> )  | \\/\\  \\___ / __ \\_/ /_/ (  <_> )\n" +
                "\\____|__  /___|  /\\____/|__|    \\___  >____  /\\____ |\\____/ \n" +
                "        \\/     \\/                   \\/     \\/      \\/       "
        );

        try {
            p1.start();
            sleep(10);
            p2.start();

            //Waits for thread to die, could have used interrupt()
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(p1.getWin()){
            winner = new Winner(p1.getPlayerName(),word.getPlayedWord());
            winnerDAO.setWinner(winner);
        }else if(p2.getWin()){
            winner = new Winner(p2.getPlayerName(),word.getPlayedWord());
            winnerDAO.setWinner(winner);
        }


    }
}
