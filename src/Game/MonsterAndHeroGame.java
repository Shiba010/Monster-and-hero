package Game;
import java.io.FileNotFoundException;
import java.util.List;

import Characters.Monsters.Monster;
import Items.ItemFactory;
import Players.Player;
import Maps.Map;
import Maps.RandMap;
import Characters.Heros.Hero;
import Characters.CharacterFactory;
import Prompt.*;
import Space.Cell;
import Party.Party;




public class MonsterAndHeroGame implements RoundBasedGame{
    private Map game_map;
    private Player player = new Player();
    private final int max_people;
    private Party monsterParty;

    public MonsterAndHeroGame() throws FileNotFoundException {
        max_people = 3;
        new CharacterFactory();
        new ItemFactory();
    }

    @Override
    public void startGame() throws FileNotFoundException {
        PrintPrompt.welcome_game();
        game_map = new RandMap();
        game_map.initial_map();
        //int NumInParty = AskPrompt.ask_how_many_heroes(max_people); // ask how many people is in the party
        createParty(max_people);
        createMonsterParty();
    }
    public void createParty(int NumInParty){ // create party by the number of members
        CharacterFactory.PrintHeroList();
        List<Hero> Hero_list = CharacterFactory.getHeroList();
        for (int i = 0; i < NumInParty;){
            Hero h = AskPrompt.ask_which_hero(Hero_list); // ask the user
            if(player.checkPartMember(h)){
                PrintPrompt.already_in_party(h);
                //select again
            }
            else{ // join the party
                PrintPrompt.join_party(h);
                player.addHeroToParty(h);
                i++;
            }
        }
        for (int i = 0; i<NumInParty; i++){
            Hero hero = player.getCharacter(i);
            hero.setHeroMark(i);
            hero.setInitialPosition(i);
            game_map.getCell(hero).GoIn(hero);
        }

    }

    private void createMonsterParty() {
        monsterParty = new Party();
        spawnNewMonsters();
    }

    public void spawnNewMonsters() {
        Party temp = CharacterFactory.getMonsterParty(player.getParty().getMaxLevel(), max_people);
        for (int i = 0; i < temp.size(); i++) {
            //
            Monster monster = (Monster) temp.getCharacter(i);
            monster.setInitialPosition(i);
            game_map.getCell(monster).GoIn(monster);
            monsterParty.addMember(monster);
        }
    }

//    @Override
//    public void startARound() {
//        while(!player.checkQuit()){
//            PrintPrompt.each_round_begin(player.getParty(), game_map);
//            String dir = AskPrompt.ask_which_direction(player.getParty());
//            if(checkQuit(dir)) break; // if the input is Q, quit the game
//            if(game_map.move(dir)) { // move position on map, true if we successfully move
//                Cell cell = game_map.getCell(); // current cell that we are going to enter
//                player = game_map.getCell().GoIn(player);
//                // evoke the event, and after the event is over, it would update the party status
//            }
//            endARound();
//        }
//        endGame();
//    }
    @Override
    public void startARound() {
        while(!player.checkQuit()){
            PrintPrompt.each_round_begin(player.getParty(), game_map);

            int heroIdx = AskPrompt.ask_which_hero_next();
            Hero hero = player.getCharacter(heroIdx);

            Cell cell = game_map.getCell(hero); // current cell that we are going to enter
            String dir;
            if(cell.isHeroNexus()){
                dir = AskPrompt.ask_which_direction_Nexus(player.getParty());
            }
            else{
                dir = AskPrompt.ask_which_direction(player.getParty());
            }
            if(checkQuit(dir)) break; // if the input is Q, quit the game
            if(game_map.move(dir, hero)) { // move position on map, true if we successfully move
                game_map.getCell(hero).GoIn(hero);
                // evoke the event, and after the event is over, it would update the party status
            }
            endARound();
        }
        endGame();
    }

    @Override
    public void endARound() {
        System.out.println("This round ends");
    }

    @Override
    public void endGame() {
        AskPrompt.close();
        System.out.println("See you next time");

    }

    public boolean checkQuit(String input){ // 'Q' for quit.
        // return true , if the input is  Q
        return input.equals("Q") || input.equals("q");
    }


}

