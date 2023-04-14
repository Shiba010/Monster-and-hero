package Space;

import Characters.Heros.Hero;


public class KoulouSpace extends Cell { //this is the class for koulou space
    public KoulouSpace() {
        super();
    }
    @Override
    public void getBuff(Hero hero){
        hero.gainStrength(20);
    }
    public void loseBuff(Hero hero){
        hero.gainStrength(-20);
    }
    @Override
    public String rep() {
        return "K";
    }
}
