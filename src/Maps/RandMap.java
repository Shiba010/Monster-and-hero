package Maps;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import Space.Cell;
import Prompt.*;
import Space.InvalidSpace;
import Space.BushSpace;
import Space.CaveSpace;
import Space.PlainSpace;
import Space.KoulouSpace;
import Space.HeroNexusSpace;
import Space.MonsterNexusSpace;




public class RandMap implements Map{ // this is a map that cells is randomly scattered
    private final Cell [][] world; // array of world
    private final int world_size_x;
    private final int world_size_y;
    private final double plain_num;
    private final double bush_num;
    private final double cave_num;
    private final double koulou_num;

    private int hero1_x;
    private int hero1_y;
    private int hero2_x;
    private int hero2_y;
    private int hero3_x;
    private int hero3_y;

    private int player_space_x;// set where the player is in x-axis
    private int party_space_y;// set where the player is in y-axis

    public RandMap(){
        // tatal 64 cells 16+6+6+9*4
        world_size_x = 8;
        world_size_y = 8;

        plain_num = 9;
        bush_num = 9;
        cave_num = 9;
        koulou_num = 9;

        hero1_x = 7;
        hero1_y = 1;
        hero2_x = 7;
        hero2_y = 4;
        hero3_x = 7;
        hero3_y = 7;

        player_space_x = 0;
        party_space_y = world_size_y-1; // start from the lowest left

        world = new Cell[world_size_y][world_size_x];
    }
    @Override
    public void initial_map() { // create cells and add them into map
        List<Cell> cell_pool = new ArrayList<Cell>();
//        int space_amount = world_size_x*world_size_y;

        for(int i = 0; i < plain_num; i++){ // add all amount of plain space to pool
            cell_pool.add(new PlainSpace());
        }
        for(int i = 0; i < bush_num; i++){ // add all amount of bush space to pool
            cell_pool.add(new BushSpace());
        }
        for(int i = 0; i < cave_num; i++){ // add all amount of cave space to pool
            cell_pool.add(new CaveSpace());
        }
        for(int i = 0; i < koulou_num; i++){ // add all amount of koulou space to pool
            cell_pool.add(new KoulouSpace());
        }

        for (int x = 0; x < world_size_x; x++){ // set first n space on x-axis is common
            for(int y = 0; y < world_size_y; y++){ // set first n space on y-axis is common
                if(y == 2 || y ==5){
                    world[x][y] = new InvalidSpace();
                }
                else{
                    if(x==0){
                        world[x][y] = new MonsterNexusSpace();
                    }
                    else if(x==7){
                        world[x][y] = new HeroNexusSpace();
                    }
                    else{
                        int removed_index = RandomGenerator.RandomIndex(cell_pool.size());
                        world[x][y] = cell_pool.get(removed_index);
                        cell_pool.remove(removed_index);
                    }
                }
            }
        }
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
        //print board
        String map_out = "";
        for(int i=0; i < world_size_x; i++){
            String firstLine = new String();
            String secondLine = new String();
            for(int j=0; j < world_size_y; j++){
                Cell c = world[i][j];
                String rep = c.rep();
                String content = c.toString();
                firstLine+=" "+rep+"-"+rep+"-"+rep+" ";
                secondLine+="|"+content+"|";
            }
            map_out+=firstLine+"\n"+secondLine+"\n"+firstLine+"\n";
        }
        return map_out;
    }





    public static void main(String[] args) throws FileNotFoundException { // for test
        RandMap m = new RandMap();
        m.initial_map();
        System.out.println(m);
    }
}
