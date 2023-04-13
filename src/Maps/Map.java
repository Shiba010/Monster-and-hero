package Maps;
import Characters.Character;
import Characters.Monsters.Monster;
import Space.Cell;
import Characters.Heros.Hero;

import java.util.List;


public interface Map { // this is the interface of map
    boolean move_up(Hero hero);
    boolean move_down(Hero hero);
    boolean move_left(Hero hero);
    boolean move_right(Hero hero);
    Cell getCell(Character character);

    boolean move(String direction, Hero hero);
    void initial_map();

    void move_down(Monster monster);
    List<Hero> heroesInRange(Monster monster);
    Monster monsterInRange(Hero hero);
    boolean checkMonsterInRange(Hero hero);
}
