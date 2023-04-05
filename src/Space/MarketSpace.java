package Space;
import Events.Market;
import Players.Player;


public class MarketSpace implements Cell {
    private boolean PlayerIsHere;
    private final Market market = new Market();

    private final double occur_probability;
    public MarketSpace() {
        PlayerIsHere = false;
        occur_probability = 1;
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

    @Override
    public boolean havePlayer() {
        return PlayerIsHere;
    }

    @Override
    public String toString() {
        if(havePlayer()) return "P";
        else return "M";
    }
}

