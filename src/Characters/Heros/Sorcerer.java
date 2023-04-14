package Characters.Heros;
import Characters.Character;
public class Sorcerer extends Hero implements Character { //this is the class for sorcerer
    public Sorcerer(String name, int mana, int str, int agi, int dex, int money, int exp) {
        super(name, mana, str, agi, dex, money, exp);
    }

    @Override
    public void skill_increase() {
        super.str_increase();
        super.agi_increase();
        super.dex_increase();
        super.dex_increase();
        super.agi_increase();
    }
}

