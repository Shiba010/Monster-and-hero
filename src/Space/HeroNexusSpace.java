package Space;

import Events.Market;
import Players.Player;
import Characters.Heros.Hero;



public class HeroNexusSpace extends Cell { //this is the class for the nexus of hero
    private final Market market = new Market();

    //private final double occur_probability;
    public HeroNexusSpace() {
        super();
        //occur_probability = 1;
    }

    @Override
    public boolean isHeroNexus() {
        return true;
    }

    @Override
    public String rep() {
        return "N";
    }
}
