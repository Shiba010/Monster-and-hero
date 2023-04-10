package Space;

import Events.Battle;
import Players.Player;
import Characters.Heros.Hero;



public class BushSpace implements Cell {
    private boolean HeroIsHere;
    private boolean MonsterIsHere;
    public BushSpace(){
        HeroMark = "  ";
        MonsterMark = "  ";
        HeroIsHere = false;
        MonsterIsHere = false;
    }
    private String HeroMark;
    private String MonsterMark;


    //private double occur_probability; // the probability to start an event
    @Override
    public void setHeroIsHere(){
        HeroIsHere = true;
        //occur_probability = 0.5;
    }
    public void setMonsterIsHere() {
        MonsterIsHere = true;
    }
    @Override
    public Hero GoIn(Hero hero){
        setHeroIsHere();
        HeroMark = hero.getHeroMark();

//        Battle battle = new Battle();
//        if(battle.event_occur(occur_probability)){
//            return battle.start_event(player);
//        }
        return hero;
    }

    @Override
    public void GoOut() {
        HeroIsHere = false;
        HeroMark = "  ";
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
        return false;
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
        return "B";
    }
}