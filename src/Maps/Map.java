package Maps;
import Space.Cell;

public interface Map { // this is the interface of map
    boolean move_up();
    boolean move_down();
    boolean move_left();
    boolean move_right();
    Cell getCell();

    boolean move(String direction);
    void initial_map();

}
