package Space;
import Players.Player;
import Characters.Heros.Hero;

public class InvalidSpace implements Cell{
    @Override
    public Hero GoIn(Hero hero) {
        System.out.println("this is inaccessible space!");
        return hero;
    }

    @Override
    public void setHeroIsHere() {

    }
    @Override
    public void setMonsterIsHere() {

    }


    @Override
    public void GoOut() {

    }

    @Override
    public boolean havePlayer() {
        return false;
    }
    @Override
    public boolean haveMonster() {
        return false;
    }
    @Override
    public boolean isHeroNexus() {
        return false;
    }
    @Override
    public String toString() {
        return "XXXXX";
    }

    @Override
    public String rep() {
        return "X";
    }
}