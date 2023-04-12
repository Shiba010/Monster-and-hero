package Maps;
import Characters.Character;
import Characters.Monsters.Monster;
import Space.Cell;
import Characters.Heros.Hero;


public interface Map { // this is the interface of map
    boolean move_up(Hero hero);
    boolean move_down(Hero hero);
    boolean move_left(Hero hero);
    boolean move_right(Hero hero);
    Cell getCell(Character character);

    boolean move(String direction, Hero hero);
    void initial_map();

    boolean move_down(Monster monster);
}
