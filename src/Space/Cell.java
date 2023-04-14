package Space;
import Characters.Heros.Hero;
import Characters.Monsters.Monster;

public abstract class Cell { //this is the class for the unit in the map
    private Hero hero;
    private Monster monster;
    private String MonsterMark;

    public Cell() {
        hero = null;
        monster = null;
        MonsterMark = "  ";
    }

    private double occur_probability; // the probability to start an event

    public void setHero(Hero hero) {
        this.hero = hero;
        //occur_probability = 0.5;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void GoIn(Hero hero) {
        setHero(hero);
        getBuff(hero);
    }

    public void GoIn(Monster monster) {
        setMonster(monster);
        MonsterMark = "M ";
    }

    public void heroLeaving() {
        loseBuff(hero);
        this.hero = null;
    }

    public void monsterLeaving() {
        monster = null;
        MonsterMark = "  ";
    }

    public void getBuff(Hero hero){

    }
    public void loseBuff(Hero hero){

    }

    public boolean haveHero() {
        return hero != null;
    }
    public boolean haveMonster() {
        return monster != null;
    }
    public boolean isHeroNexus() {
        return false;
    }
    public boolean isMonsterNexus() {
        return false;
    }

    public String toString() {
        String heroMark = (hero != null) ? hero.getHeroMark() : "  ";
        return heroMark+" "+MonsterMark;
    }

    public abstract String rep();

    public Hero getHero() {
        return hero;
    }

    public Monster getMonster() {
        return monster;
    }

    // TODO method for giving hero a bonus at this space

    // TODO method for giving monster a bonus at this space
}
