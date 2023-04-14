package Characters.Heros;
import Characters.Character;

public class Paladin extends Hero implements Character{ //this is the class for paladin
    public Paladin(String name, int mana, int str, int agi, int dex, int money, int exp) {
        super(name, mana, str, agi, dex, money, exp);
    }

    @Override
    public void skill_increase() {
        super.str_increase();
        super.agi_increase();
        super.dex_increase();
        super.str_increase();
        super.dex_increase();
    }
}
