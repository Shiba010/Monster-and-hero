package Space;
import Characters.Heros.Hero;
import Characters.Monsters.Monster;

public abstract class Cell {
    private boolean HeroIsHere;
    private boolean MonsterIsHere;
    private String HeroMark;
    private String MonsterMark;

    public Cell() {
        HeroMark = "  ";
        MonsterMark = "  ";
        HeroIsHere = false;
        MonsterIsHere = false;
    }

    private double occur_probability; // the probability to start an event

    public void setHeroIsHere() {
        HeroIsHere = true;
        //occur_probability = 0.5;
    }
    public void setMonsterIsHere() {
        MonsterIsHere = true;
    }

    public void GoIn(Hero hero) {
        setHeroIsHere();
//        Battle battle = new Battle();
//        if (battle.event_occur(occur_probability)) {
//            return battle.start_event(player);
//        }
        HeroMark = hero.getHeroMark();
    }

    public void GoIn(Monster monster) {
        setMonsterIsHere();
        MonsterMark = "M ";
    }

    public void heroLeaving() {
        HeroIsHere = false;
        HeroMark = "  ";
    }

    public void monsterLeaving() {
        MonsterIsHere = false;
        MonsterMark = "  ";
    }

    public boolean haveHero() {
        return HeroIsHere;
    }
    public boolean haveMonster() {
        return MonsterIsHere;
    }
    public boolean isHeroNexus() {
        return false;
    }
    public boolean isMonsterNexus() {
        return false;
    }

    public String toString() {
        return HeroMark+" "+MonsterMark;
    }

    public abstract String rep();

    // TODO method for giving hero a bonus at this space

    // TODO method for giving monster a bonus at this space
}
