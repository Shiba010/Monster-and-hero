import java.io.FileNotFoundException;
import Game.MonsterAndHeroGame;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MonsterAndHeroGame M = new MonsterAndHeroGame();
        M.startGame();
        M.startARound();
    }
}