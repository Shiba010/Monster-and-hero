package Space;

import Characters.Heros.Hero;



public class BushSpace extends Cell { //this is the class for bush space
    public BushSpace() {
        super();
    }

    @Override
    public void getBuff(Hero hero){
        hero.gainDex(20);
    }

    public void loseBuff(Hero hero){
        hero.gainDex(-20);
    }

    @Override
    public String rep() {
        return "B";
    }
}