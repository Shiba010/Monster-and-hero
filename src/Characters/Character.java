package Characters;

public interface Character {
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
    int getPositionX();
    int getPositionY();

    String getTitle();


}

