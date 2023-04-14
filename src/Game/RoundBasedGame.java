package Game;
import java.io.FileNotFoundException;

public interface RoundBasedGame { //this is the interface for round base game
    abstract void startARound();
    abstract void endARound();
    abstract void startGame() throws FileNotFoundException;
    abstract void endGame();
}
