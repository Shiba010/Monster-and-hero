package Space;

import Characters.Heros.Hero;



public class CaveSpace extends Cell { //this is the class for cave space
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