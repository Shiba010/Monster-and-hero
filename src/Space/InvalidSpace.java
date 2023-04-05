package Space;
import Players.Player;

public class InvalidSpace implements Cell{
    @Override
    public Player GoIn(Player player) {
        System.out.println("this is inaccessible space!");
        return player;
    }

    @Override
    public void setPlayerIsHere() {

    }

    @Override
    public void GoOut() {

    }

    @Override
    public boolean havePlayer() {
        return false;
    }

    @Override
    public String toString() {
        return "D";
    }
}