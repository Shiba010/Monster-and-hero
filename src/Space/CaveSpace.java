package Space;

import Events.Battle;
import Players.Player;



public class CaveSpace implements Cell {
    private boolean PlayerIsHere;
    private boolean MonsterIsHere;
    public CaveSpace(){
        PlayerIsHere = false;
    }

    //private double occur_probability; // the probability to start an event

    public void setPlayerIsHere(){
        PlayerIsHere = true;
        //occur_probability = 0.5;
    }
    public void setMonsterIsHere() {
        MonsterIsHere = true;
    }
    @Override
    public Player GoIn(Player player){
        setPlayerIsHere();
//        Battle battle = new Battle();
//        if(battle.event_occur(occur_probability)){
//            return battle.start_event(player);
//        }
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
    public boolean haveMonster() {
        return MonsterIsHere;
    }


    @Override
    public String toString() {
        if(havePlayer()) return "  P  ";
        else return "     ";
    }

    @Override
    public String rep() {
        return "C";
    }
}