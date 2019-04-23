package UTN;

import UTN.Models.Player;
import UTN.Models.Word;

public class App 
{
    public static void main( String[] args )
    {
        Word word = new Word();
        Player p = new Player(word, 10);

        Thread p1 = new Thread(p);
        Thread p2 = new Thread(p);

        p1.start();



    }
}
