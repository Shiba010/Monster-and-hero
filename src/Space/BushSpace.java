package Space;

import Events.Battle;
import Players.Player;



public class BushSpace implements Cell {
    private boolean PlayerIsHere;
    private boolean MonsterIsHere;
    public BushSpace(){
        PlayerIsHere = false;
    }
    private int characterNum = 0;

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
        characterNum+=1;

//        Battle battle = new Battle();
//        if(battle.event_occur(occur_probability)){
//            return battle.start_event(player);
//        }
        return player;
    }

    @Override
    public void GoOut() {
        PlayerIsHere = false;
        characterNum-=1;
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
        if(havePlayer()){
            if (characterNum == 1){

            }
            if (characterNum == 2){

            }
            return "  P  ";
        }
        else return "     ";
    }
    @Override
    public String rep() {
        return "B";
    }
}