package Space;
import Players.Player;
import Characters.Heros.Hero;

public interface Cell {
    void GoIn(Hero hero); //player goin
    void setHeroIsHere();
    void setMonsterIsHere();
    void GoOut();
    boolean havePlayer();
    boolean haveMonster();
    boolean isHeroNexus();
    //int characterNum;
    public String rep();


}
