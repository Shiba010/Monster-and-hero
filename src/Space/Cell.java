package Space;
import Players.Player;

public interface Cell {
    Player GoIn(Player player); //player goin
    void setPlayerIsHere();
    void GoOut();
    boolean havePlayer();
    boolean haveMonster();
    //int characterNum;
    public String rep();


}
