package Game;
import java.io.FileNotFoundException;

public interface RoundBasedGame {
    abstract void startARound();
    abstract void endARound();
    abstract void startGame() throws FileNotFoundException;
    abstract void endGame();
}
