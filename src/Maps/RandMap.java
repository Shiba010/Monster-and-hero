package Maps;

import Characters.Character;
import Characters.Heros.Hero;
import Characters.Monsters.Monster;
import Events.Market;
import Items.Item;
import Items.Potions;
import Players.Player;
import Prompt.AskPrompt;
import Prompt.PrintPrompt;
import Space.*;
import Utility.Scanner;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




public class RandMap implements Map{ // this is a map that cells is randomly scattered
    private final Cell [][] world; // array of world
    private final int world_size_x;
    private final int world_size_y;
    private final double plain_num;
    private final double bush_num;
    private final double cave_num;
    private final double koulou_num;
    private Market market = new Market();
    private Scanner s = new Scanner();

    public RandMap(){
        // tatal 64 cells 16+6+6+9*4
        world_size_x = 8;
        world_size_y = 8;

        plain_num = 9;
        bush_num = 9;
        cave_num = 9;
        koulou_num = 9;

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
    public boolean move(String direction, Hero hero) { // return true if we actually move
        switch (direction) {
            case "w":
                return move_up(hero);
            case "a":
                return move_left(hero);
            case "s":
                return move_down(hero);
            case "d":
                return move_right(hero);
            case "m": // market does not end turn
                market.start_event(hero);
                return false;
            case "e":
                return equip(hero);
            case "p":
                return usePotion(hero);
            case "t":
                return teleport(hero);
            case "r":
                return recall(hero);
        }

        return false;
    }

    public boolean teleport(Hero hero){
        int destinationX = 0;
        int destinationY = 0;
        boolean valid = false;
        while(!valid){
            AskPrompt.ask_teleport();
            destinationX = s.ScanInt();
            destinationY = s.ScanInt();
            valid = checkValidMove(hero, destinationY, destinationX) &
                    checkTeleport(hero, destinationY, destinationX);
            if (!valid)
                PrintPrompt.invalidTeleport();
        }
        completeMove(hero, destinationY, destinationX);
        return true;
    }

    private boolean checkTeleport(Hero hero, int destY, int destX) {
        // destination Y cannot be 0 (or the game is broken)
        // hero must teleport to different lane
        if (destY == 0) return false;
        Set<Integer> sameLaneIndices = new HashSet<>();
        int origX = hero.getPositionX();
        sameLaneIndices.add(origX);
        sameLaneIndices.add(origX + 1);
        sameLaneIndices.add(origX - 1);
        return !sameLaneIndices.contains(destX);
    }

    public boolean recall(Hero hero){
        int index = java.lang.Character.getNumericValue(hero.getHeroMark().charAt(1)) - 1;
        int destinationX = (index * 3) + 1;
        int destinationY = 7;
        if (!checkValidMove(hero, destinationY, destinationX)) {
            PrintPrompt.invalidRecall();
            return false;
        }
        completeMove(hero, destinationY, destinationX);
        return true;
    }


    public boolean equip(Hero hero) { //Hero equip weapon or armor
        Player player = new Player();
        String index_string = AskPrompt.ask_equip(hero, hero.getEquipment_inventory());
        //Ask the player that what items should this hero equip
        if (index_string.equals("Q") | index_string.equals("q")) {//quit
            PrintPrompt.handleQuit();
        } else if (index_string.equals("L") | index_string.equals("l"))
            return false;
        ; // leave the process of choosing equipment

        hero.equip(Integer.parseInt(index_string));
        //hero_party.updateCharacterBYSearch(hero); // update hero party
        return true;
    }

    public boolean usePotion(Hero hero){
        Player player = new Player();
        String index_string = AskPrompt.ask_which_potion(hero, hero.getPotion_inventory());
        //Ask the player which spell/potion wants to use.
        if (index_string.equals("Q")|index_string.equals("q")) {//quit
            PrintPrompt.handleQuit();
        } else if (index_string.equals("L")|index_string.equals("l"))
            return false; // ao back to choose action
        int index = Integer.parseInt(index_string);
        Item item = hero.getPotion_inventory().get(index);
        //**********************************
        Potions potion = (Potions) item;
        potion.consume(hero); // use Potion
        //hero_party.updateCharacterBYSearch(hero); // update hero party
        return true;
    }

//    public void useSpell(Hero hero){
//        Player player = new Player();
//        String index_string = AskPrompt.ask_which_potion_spell(hero, hero.getSpell_inventory());
//        //Ask the player which spell/potion wants to use.
//        if (index_string.equals("Q")|index_string.equals("q")) {//quit
//            player.Quit();
//            return;
//        } else if (index_string.equals("L")|index_string.equals("l")) return; // ao back to choose action
//        int index = Integer.parseInt(index_string);
//        Item item = hero.getSpell_inventory().get(index);
//        Spell spell = (Spell) item;
//        //**********************************
//
//            if (hero.getSpellMana(index) > hero.getMana()) {
//                PrintPrompt.Print_spell_cannot_use();
//                return;
//            }
//            String Monster_index_string = AskPrompt.ask_Monster(hero_party, monster_party); // ask player which monster should attack
//            if (Monster_index_string.equals("Q")|Monster_index_string.equals("q")) {//quit
//                player.Quit();
//                return;
//            } else if (Monster_index_string.equals("L")|Monster_index_string.equals("l")) return; // ao back to choose action
//            Monster monster = (Monster) monster_party.getCharacter(Integer.parseInt(Monster_index_string)); //get monster
//            hero.useSpell(monster, index); //use spell
//            hero_party.updateCharacterBYSearch(hero); // update hero party
//
//            if (!monster.checkAlive()) {
//                hero_party.gainMoneyExp(monster.getDeadGold(), monster.getDeadExp(1));
//                monster_party.remove(monster);
//
//            return;
//
//        }
//
//        return;
//    }





    private boolean checkValidMove(Hero hero, int destinationY, int destinationX) {
        if (destinationY < 0 || destinationY >= world_size_y)
            return false; // Y coordinate out of bounds
        if (destinationX < 0 || destinationX >= world_size_x)
            return false; // X coordinate out of bounds
        if (world[destinationY][destinationX] instanceof InvalidSpace)
            return false; // inaccessible
        // if destination space already has a hero
        if (world[destinationY][destinationX].haveHero())
            return false;
        // hero cannot move past a monster in the same lane
        Monster monster = monsterInRange(hero);
        return monster == null || destinationY >= monster.getPositionY();

    }

    @Override
    public boolean move_up(Hero hero) { //return false if we cant move up
        int positionX=hero.getPositionX();
        int positionY=hero.getPositionY();
        if (!checkValidMove(hero, positionY - 1, positionX)) {
            PrintPrompt.cannot_move();
            return false;
        }
        completeMove(hero, positionY - 1, positionX);
        return true;
    }

    @Override
    public boolean move_down(Hero hero) { //return false if we cant move sown
        int positionX = hero.getPositionX();
        int positionY = hero.getPositionY();
        if (!checkValidMove(hero, positionY + 1, positionX)) {
            PrintPrompt.cannot_move();
            return false;
        }
        completeMove(hero, positionY + 1, positionX);
        return true;
    }

    @Override
    public boolean move_left(Hero hero) { //return false if we cant move left
        int positionX = hero.getPositionX();
        int positionY = hero.getPositionY();
        if (!checkValidMove(hero, positionY, positionX - 1)) {
            PrintPrompt.cannot_move();
            return false;
        }
        completeMove(hero, positionY, positionX - 1);
        return true;
    }

    @Override
    public boolean move_right(Hero hero) { //return false if we cant move right
        int positionX = hero.getPositionX();
        int positionY = hero.getPositionY();
        if (!checkValidMove(hero, positionY, positionX + 1)) {
            PrintPrompt.cannot_move();
            return false;
        }
        completeMove(hero, positionY, positionX + 1);
        return true;
    }

    private void completeMove(Hero hero, int destY, int destX) {
        getCell(hero).heroLeaving(); // leave current cell
        hero.setPositionY(destY);
        hero.setPositionX(destX);
        getCell(hero).GoIn(hero); // enter new cell
    }

    @Override
    public void move_down(Monster monster) {
        int positionX = monster.getPositionX();
        int positionY = monster.getPositionY();
        if (world[positionY+1][positionX].haveMonster())
            return;
        // if there are heroes within the monster's range, stop moving and attack one of them
        List<Hero> heroes = heroesInRange(monster);
        int minHeroY = furthestHero(heroes);
        if (minHeroY == positionY) {
            Hero toBeAttacked = heroes.get(RandomGenerator.RandomIndex(heroes.size()));
            monster.attack(toBeAttacked);
            // if hero fainted, make them respawn in original nexus, restore all HP and Mana, take away $100
            if (!toBeAttacked.checkAlive()) {
                recall(toBeAttacked);
                getCell(toBeAttacked).GoIn(toBeAttacked);
                toBeAttacked.revive();
            }
            return;
        }
        getCell(monster).monsterLeaving();
        monster.setPositionY(positionY + 1);
        getCell(monster).GoIn(monster);
    }

    private int furthestHero(List<Hero> heroes) {
        int y = world_size_y;
        for (Hero hero: heroes) {
            y = Math.min(hero.getPositionY(), y);
        }
        return y;
    }

    @Override
    public List<Hero> heroesInRange(Monster monster) {
        // Monster's attack range:
        // W, same spot, E
        // SW, S, SE
        List<Hero> inRange = new ArrayList<>();
        int positionX = monster.getPositionX();
        int positionY = monster.getPositionY();
        for (int i = positionX - 1; i <= positionX + 1; i++) {
            try {
                if (world[positionY][i].haveHero())
                    inRange.add(world[positionY][i].getHero());
                if (world[positionY+1][i].haveHero())
                    inRange.add(world[positionY+1][i].getHero());
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return inRange;
    }

    @Override
    public Monster monsterInRange(Hero hero) {
        int positionX = hero.getPositionX();
        int positionY = hero.getPositionY();
        for (int i = positionX - 1; i <= positionX + 1; i++) {
            try {
                if (world[positionY][i].haveMonster())
                    return world[positionY][i].getMonster();
                if (world[positionY-1][i].haveMonster())
                    return world[positionY-1][i].getMonster();
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return null;
    }
    @Override
    public boolean checkMonsterInRange(Hero hero){
        int positionX = hero.getPositionX();
        int positionY = hero.getPositionY();
        for (int i = positionX - 1; i <= positionX + 1; i++) {
            try {
                if (world[positionY][i].haveMonster())
                    return true;
                if (world[positionY-1][i].haveMonster())
                    return true;
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        return false;
    }

    @Override
    public Cell getCell(Character character){ // return the Cell
        int positionX = character.getPositionX();
        int positionY = character.getPositionY();
        return world[positionY][positionX];
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
