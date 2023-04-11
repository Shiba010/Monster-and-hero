package Space;
import Players.Player;
import Characters.Heros.Hero;

public class InvalidSpace extends Cell{
    @Override
    public void GoIn(Hero hero) {
        System.out.println("You can't move into an inaccessible space!");
    }

    @Override
    public void setHeroIsHere() {

    }
    @Override
    public void setMonsterIsHere() {

    }

    @Override
    public void heroLeaving() {

    }

    @Override
    public boolean haveHero() {
        return false;
    }
    @Override
    public boolean haveMonster() {
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