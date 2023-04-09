package Space;

import Events.Market;
import Players.Player;



public class HeroNexusSpace implements Cell {
    private boolean PlayerIsHere;
    private boolean MonsterIsHere;
    private final Market market = new Market();

    private final double occur_probability;
    public HeroNexusSpace() {
        PlayerIsHere = false;
        occur_probability = 1;
    }
    public void setMonsterIsHere() {
        MonsterIsHere = true;
    }

    @Override
    public Player GoIn(Player player) {
        setPlayerIsHere();
        if(market.event_occur(occur_probability)){
            return market.start_event(player);
        }
        return player;
    }
    @Override
    public void GoOut() {
        PlayerIsHere = false;
    }

    @Override
    public void setPlayerIsHere() {
        PlayerIsHere = true;
    }
    public void setMonsterIsHere() {
        MonsterIsHere = true;
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
        return "N";
    }
}
