package Maps;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import Space.Cell;
import Prompt.*;
import Space.CommonSpace;
import Space.MarketSpace;
import Space.InvalidSpace;


public class RandMap implements Map{ // this is a map that cells is randomly scattered
    private final Cell [][] world; // array of world
    private final int world_size_x;
    private final int world_size_y;
    private final double inaccessible_portion;
    private final double market_portion;
    private final double common_portion;
    private int player_space_x;// set where the player is in x-axis
    private int party_space_y;// set where the player is in y-axis

    public RandMap(){
        world_size_x = 12;
        world_size_y = 8;
        inaccessible_portion = 0.2;
        market_portion = 0.2;
        player_space_x = 0;
        party_space_y = world_size_y-1; // start from the lowest left
        common_portion = (1 - inaccessible_portion - market_portion);
        world = new Cell[world_size_y][world_size_x];
    }
    @Override
    public void initial_map() { // create cells and add them into map
        List<Cell> cell_pool = new ArrayList<Cell>();
        int space_amount = world_size_x*world_size_y;
        for(int i = 0; i < space_amount*inaccessible_portion; i++){ // add all amount of inaccessible space to pool
            cell_pool.add(new InvalidSpace());
        }
        for(int i = 0; i < space_amount*market_portion; i++){
            MarketSpace MS = new MarketSpace();
            cell_pool.add(MS);
        }
        for(int i = 0; cell_pool.size() <= space_amount; i++){
            cell_pool.add(new CommonSpace());
        }
        for (int x = 0; x < world_size_x; x++){ // set first n space on x-axis is common
            for(int y = 0; y < world_size_y; y++){ // set first n space on y-axis is common
                int removed_index = RandomGenerator.RandomIndex(cell_pool.size());
                world[y][x] = cell_pool.get(removed_index);
                cell_pool.remove(removed_index);
            }
        }
        // if start place is occupied
        if(!(world[party_space_y][player_space_x] instanceof CommonSpace)){
            initial_map(); // recreate a map
        }
        // put party in the start place
        world[party_space_y][player_space_x].setPlayerIsHere();
    }

    @Override
    public boolean move(String direction) { // return true if we actually move
        if(direction.equals("W")|direction.equals("w")) return move_up();
        else if (direction.equals("A")|direction.equals("a")) return move_left();
        else if (direction.equals("S")|direction.equals("s")) return move_down();
        else if (direction.equals("D")|direction.equals("d")) return move_right();
        return false;
    }

    @Override
    public boolean move_up() { //return false if we cant move up
        if(party_space_y - 1 < 0 || world[party_space_y-1][player_space_x] instanceof InvalidSpace){
            // if the pLace is out of bounds or inaccessible;
            PrintPrompt.cannot_move();
            return false;
        }
        world[party_space_y][player_space_x].GoOut(); // go out current cell
        party_space_y = party_space_y-1;
        return true;
    }

    @Override
    public boolean move_down() { //return false if we cant move sown
        if(party_space_y + 1 >= world_size_y|| world[party_space_y+1][player_space_x] instanceof InvalidSpace){
            // if the place is out of bounds or inaccessible;
            PrintPrompt.cannot_move();
            return false;
        }
        world[party_space_y][player_space_x].GoOut(); // go out current cell
        party_space_y = party_space_y + 1;
        return true;
    }

    @Override
    public boolean move_left() { //return false if we cant move left
        if(player_space_x - 1 < 0 || world[party_space_y][player_space_x-1] instanceof InvalidSpace){
            // if the place is out of bounds or inaccessible;
            PrintPrompt.cannot_move();
            return false;
        }
        world[party_space_y][player_space_x].GoOut(); // go out current cell
        player_space_x = player_space_x - 1;
        return true;
    }

    @Override
    public boolean move_right() { //return false if we cant move right
        if(player_space_x + 1 >= world_size_x || world[party_space_y][player_space_x+1] instanceof InvalidSpace){
            // if the place is out of bounds or inaccessible;
            PrintPrompt.cannot_move();
            return false;
        }
        world[party_space_y][player_space_x].GoOut(); // go out current cell
        player_space_x = player_space_x + 1;
        return true;
    }
    @Override
    public Cell getCell(){ // return the Cell
        return world[party_space_y][player_space_x];
    }


    @Override
    public String toString() {
        String map_out = "";
        String firstLine = "";
        for(int i = 0; i < world_size_x; i++) firstLine+="+---";
        firstLine += "+\n";
        for(int y = 0; y < world_size_y; y++){
            map_out += firstLine + PrintLine(y);
        }
        map_out += firstLine;
        return map_out;
    }

    public String PrintLine(int y){
        String Line = "";
        for(int x = 0; x < world_size_x; x++) Line += "| " + world[y][x].toString() + " ";
        Line += "|\n";
        return Line;
    }

    public static void main(String[] args) throws FileNotFoundException { // for test
        RandMap m = new RandMap();
        m.initial_map();
        System.out.println(m);
    }
}
