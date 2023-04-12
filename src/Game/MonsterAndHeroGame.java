package Game;
import java.io.FileNotFoundException;
import java.util.List;

import Characters.Monsters.Monster;
import Items.Item;
import Items.ItemFactory;
import Items.Spells.Spell;
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
    private int roundCount;

    public MonsterAndHeroGame() throws FileNotFoundException {
        max_people = 3;
        new CharacterFactory();
        new ItemFactory();
        roundCount = 0;
    }

    @Override
    public void startGame() throws FileNotFoundException {
        PrintPrompt.welcome_game();
        game_map = new RandMap();
        game_map.initial_map();
        //int NumInParty = AskPrompt.ask_how_many_heroes(max_people); // ask how many people is in the party
        createParty(max_people);
        monsterParty = new Party();

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

    public void spawnNewMonsters() {
        Party temp = CharacterFactory.getMonsterParty(player.getParty().getMaxLevel(), max_people);
        for (int i = 0; i < temp.size(); i++) {
            Monster monster = (Monster) temp.getCharacter(i);
            monster.setInitialPosition(i);
            if (game_map.getCell(monster).haveMonster())
                continue;
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
        int spawnFrequency = 8;
        while (true) {
            if (roundCount % spawnFrequency == 0)
                spawnNewMonsters();
            heroesTurn();
            monstersTurn();
            endARound();
        }
    }

    private void heroesTurn() {
        PrintPrompt.each_round_begin(player.getParty(), game_map);

        for (int i = 0; i < player.getParty().size(); i++) {
            Hero hero = player.getCharacter(i);
            Cell cell = game_map.getCell(hero); // current cell that we are going to enter
            String dir;
            if(cell.isHeroNexus())
            {
                if(game_map.checkMonsterInRange(hero)){
                    dir = AskPrompt.ask_which_direction_Nexus_attack(hero);
                }
                else{
                    dir = AskPrompt.ask_which_direction_Nexus(hero);
                }

            }
            else {
                if(game_map.checkMonsterInRange(hero)){
                    dir = AskPrompt.ask_which_direction_attack(hero);
                }
                else{
                    dir = AskPrompt.ask_which_direction(hero);
                }
            }

            if(checkQuit(dir)) // if the input is Q, quit the game
                PrintPrompt.handleQuit();

            while(dir.equals("M") || dir.equals("m")){ // do action in market doesn't make a turn
                game_map.move(dir, hero);
                dir = AskPrompt.ask_which_direction(hero);
            }

            if(dir.equals("Sp")) { // do action in market doesn't make a turn
                Monster monster = game_map.monsterInRange(hero);
                useSpell(hero, monster);
            }
            else if(game_map.move(dir, hero)) { // move position on map, true if we successfully move
                game_map.getCell(hero).GoIn(hero);
                // evoke the event, and after the event is over, it would update the party status
                if (game_map.getCell(hero).isMonsterNexus())
                    handleWin(hero);
            }
        }
    }

    private void monstersTurn() {
        for (int i = 0; i < monsterParty.size(); i++) {
            Monster monster = (Monster) monsterParty.getCharacter(i);
            // TODO check if monster can move
            if (game_map.move_down(monster)) {
                game_map.getCell(monster).GoIn(monster);
                if (game_map.getCell(monster).isHeroNexus())
                    handleLoss(monster);
            }
        }
    }

    @Override
    public void endARound() {
        System.out.println("End of turn\n");
        roundCount++;
    }

    @Override
    public void endGame() {
        AskPrompt.close();
        System.out.println("See you next time");
    }

    public void useSpell(Hero hero, Monster monster) {
        Player player = new Player();
        String index_string = AskPrompt.ask_which_spell(hero, hero.getSpell_inventory());
        //Ask the player which spell/potion wants to use.
        if (index_string.equals("Q") | index_string.equals("q")) {//quit
            player.Quit();

            int index = Integer.parseInt(index_string);
            Item item = hero.getSpell_inventory().get(index);
            Spell spell = (Spell) item;
            //**********************************

            if (hero.getSpellMana(index) > hero.getMana()) {
                PrintPrompt.Print_spell_cannot_use();
            }
            System.out.println("spell!");
            System.out.println("spell!");
            System.out.println("spell!");
            hero.useSpell(monster, spell); //use spell
            //hero_party.updateCharacterBYSearch(hero); // update hero party

            if (!monster.checkAlive()) {
                hero.gainGold(monster.getDeadGold());
                hero.gainExp(monster.getDeadExp(1));
                monsterParty.remove(monster);
            }
        }
    }

    public boolean checkQuit (String input){ // 'Q' for quit.
            // return true , if the input is  Q
            return input.equals("Q") || input.equals("q");
    }


    private void handleLoss(Monster monster) {
        System.out.println(monster.getName() + " has reached the Heroes' Nexus.");
        System.out.println("Monsters win!");
        System.out.println("GAME OVER");
        System.exit(0);
    }

    private void handleWin(Hero hero) {
        System.out.println(hero.getName() + " has reached the Monsters' Nexus.");
        System.out.println("YOU WIN!");
        endGame();
        System.exit(0);
    }
}

