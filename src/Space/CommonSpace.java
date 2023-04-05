package Space;
import Players.Player;
import Events.*;

public class CommonSpace implements Cell {
    private boolean PlayerIsHere;
    public CommonSpace(){
        PlayerIsHere = false;
    }

    private double occur_probability; // the probability to start an event

    public void setPlayerIsHere(){
        PlayerIsHere = true;
        occur_probability = 0.5;
    }
    @Override
    public Player GoIn(Player player){
        setPlayerIsHere();
        Battle battle = new Battle();
        if(battle.event_occur(occur_probability)){
            return battle.start_event(player);
        }
        return player;
    }

    @Override
    public void GoOut() {
        PlayerIsHere = false;
    }

    @Override
    public boolean havePlayer() {
        return PlayerIsHere;
    }


    @Override
    public String toString() {
        if(havePlayer()) return "P";
        else return " ";
    }
}
