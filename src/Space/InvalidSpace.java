package Space;
import Characters.Heros.Hero;
import Characters.Monsters.Monster;

public class InvalidSpace extends Cell{ //this is the class for invalid space
    @Override
    public void GoIn(Hero hero) {
        System.out.println("You can't move into an inaccessible space!");
    }

    @Override
    public void setHero(Hero hero) {

    }
    @Override
    public void setMonster(Monster monster) {

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