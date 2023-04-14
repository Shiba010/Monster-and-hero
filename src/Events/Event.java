package Events;
import Players.Player;

public interface Event { //this is the interface for event
    // the event interface is evoked by a chance when a hero enter a cell
    // for this game, the event have two implementation Market and Battle
    boolean event_occur(double probability);
    Player start_event(Player player); //Player in and Player out

}
