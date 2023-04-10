package Space;

import Events.Market;
import Players.Player;
import Characters.Heros.Hero;



public class HeroNexusSpace implements Cell {
    private boolean HeroIsHere;
    private boolean MonsterIsHere;
    private String HeroMark;
    private String MonsterMark;
    private final Market market = new Market();

    //private final double occur_probability;
    public HeroNexusSpace() {
        HeroMark = "  ";
        MonsterMark = "  ";
        HeroIsHere = false;
        MonsterIsHere = false;
        //occur_probability = 1;
    }


    @Override
    public Hero GoIn(Hero hero) {
        setHeroIsHere();
//        if(market.event_occur(occur_probability)){
//            return market.start_event(player);
//        }
        HeroMark = hero.getHeroMark();
        return hero;
    }
    @Override
    public void GoOut() {
        HeroIsHere = false;
        HeroMark = "  ";
    }

    @Override
    public void setHeroIsHere() {
        HeroIsHere = true;
    }
    @Override
    public void setMonsterIsHere() {
        HeroIsHere = true;
    }


    @Override
    public boolean havePlayer() {
        return HeroIsHere;
    }
    @Override
    public boolean haveMonster() {
        return MonsterIsHere;
    }
    @Override
    public boolean isHeroNexus() {
        return true;
    }
    @Override
    public String toString() {
        if (MonsterIsHere){
            MonsterMark = "M ";
        }
        else{
            MonsterMark = "  ";
        }
        return HeroMark+" "+MonsterMark;
    }

    @Override
    public String rep() {
        return "N";
    }
}
