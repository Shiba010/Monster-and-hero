import java.io.FileNotFoundException;
import Game.LegendsOfValorGame;

public class Main { // this is the main class
    public static void main(String[] args) throws FileNotFoundException {
        LegendsOfValorGame M = new LegendsOfValorGame();
        M.startGame();
        M.startARound();
    }
}