package Characters;

public interface Character { //this is the interface for character
    void attack(Character c);
    String getName();
    int getLevel();
    boolean dodge();
    boolean checkAlive();
    void dead();
    void takeDamage(int damage, Character c);
    void gainExp(int exp);
    int getHP();
    void gainGold(int extra_money);
    public void setInitialPosition(int index);
    int getPositionX();
    int getPositionY();
    public void setPositionX(int positionX);
    public void setPositionY(int positionY);

    String getTitle();


}

