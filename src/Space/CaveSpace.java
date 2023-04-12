package Space;

import Events.Battle;
import Players.Player;
import Characters.Heros.Hero;



public class CaveSpace extends Cell {
    public CaveSpace() {
        super();
    }

    @Override
    public void getBuff(Hero hero){
        hero.gainAgi(20);
    }

    public void loseBuff(Hero hero){
        hero.gainAgi(-20);
    }

    @Override
    public String rep() {
        return "C";
    }
}