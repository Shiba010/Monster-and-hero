package Space;
import Players.Player;
import Characters.Heros.Hero;
public interface Cell {
    Hero GoIn(Hero hero); //player goin
    void setHeroIsHere();
    void setMonsterIsHere();
    void GoOut();
    boolean havePlayer();
    boolean haveMonster();
    boolean isHeroNexus();
    //int characterNum;
    public String rep();


}
