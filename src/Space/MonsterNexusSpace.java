package Space;

import Events.Battle;
import Players.Player;
import Characters.Heros.Hero;



public class MonsterNexusSpace extends Cell {
    public MonsterNexusSpace() {
        super();
    }

    @Override
    public boolean isMonsterNexus() {
        return true;
    }

    @Override
    public String rep() {
        return "N";
    }
}
