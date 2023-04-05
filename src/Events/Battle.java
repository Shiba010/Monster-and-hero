package Events;
import java.util.ArrayList;
import java.util.List;
import Players.Player;
import Items.Item;
import Prompt.*;
import Items.Potions;
import Items.Spells.Spell;
import Party.Party;

import Maps.RandomGenerator;
import Characters.Heros.Hero;
import Characters.CharacterFactory;
import Characters.Monsters.Monster;
import Characters.Character;


public class Battle implements Event{ // this is battle class, the main method is start event
    private Player player; // the Player in the battle
    private Party hero_party = new Party(); // party for heroes
    private final List<Hero> dead_pool = new ArrayList<Hero>(); // when hero dies, he would be moved to dead pool
    private Party monster_party;


    public Party createMonsterParty(int max_level, int num_hero){ // return the
        return  CharacterFactory.getMonsterParty(max_level,num_hero);
    }

    @Override
    public boolean event_occur(double probability) {
        return RandomGenerator.TrueFalseGen(probability);
    }

    @Override
    public Player start_event(Player player) { // start battle
        this.player = player;
        hero_party = player.getParty();
        int max_level = hero_party.getMaxLevel();
        monster_party = createMonsterParty(max_level, hero_party.size()); // create monster party
        PrintPrompt.Print_battle_start(hero_party, monster_party);
        while(!player.checkQuit()){
            startHeroTurn(); // hero turns
            if(player.checkQuit()) {
                return player;
            }
            startMonsterTurn(); // monsters turns
            if(checkWin()) {
                if(monster_party.empty()){
                    System.out.println("\n*************** Heroes win the battle ****************\n");
                }
                else if(hero_party.empty()){
                    System.out.println("\n*************** Monsters win the battle ****************\n");
                    player.Quit();
                }
                return player;
            }
        }

        return this.player;
    }

    public void Hero_do_action(Hero hero){
        while (!player.checkQuit()) {
            String player_decision = AskPrompt.ask_Heros_turn(hero, hero_party, monster_party);
            switch (player_decision) {
                case "Q"://if is Q, quit the game
                case "q":
                    player.Quit();
                    return;
                //"E"  for equip
                case "E":
                case "e": { // choose to equip
                    String index_string = AskPrompt.ask_equip(hero, hero.getEquipment_inventory());
                    //Ask the player that what items should this hero equip
                    if (index_string.equals("Q")|index_string.equals("q")) {//quit
                        player.Quit();
                        return;
                    } else if (index_string.equals("L")|index_string.equals("l")) continue;
                    ; // leave the process of choosing equipment

                    hero.equip(Integer.parseInt(index_string));
                    hero_party.updateCharacterBYSearch(hero); // update hero party

                    // "A" for attack
                    break;
                }
                case "A":
                case "a": { /// attack
                    String index_string = AskPrompt.ask_Monster(hero_party, monster_party); // ask player which monster should attack

                    if (index_string.equals("Q")|index_string.equals("q")) {//quit
                        player.Quit();
                        return;
                    } else if (index_string.equals("L")|index_string.equals("l")) continue; // ao back to choose action
                    Monster monster = (Monster) monster_party.getCharacter(Integer.parseInt(index_string));
                    hero.attack(monster); // hero attack

                    if (!monster.checkAlive()) {
                        hero_party.gainMoneyExp(monster.getDeadGold(), monster.getDeadExp(1));
                        monster_party.remove(monster);
                    }
                    return;

                }
                case "S":
                case "s": { /// use spell or potion
                    String index_string = AskPrompt.ask_which_potion_spell(hero, hero.getConsumables_inventory());
                    //Ask the player which spell/potion wants to use.
                    if (index_string.equals("Q")|index_string.equals("q")) {//quit
                        player.Quit();
                        return;
                    } else if (index_string.equals("L")|index_string.equals("l")) continue; // ao back to choose action
                    int index = Integer.parseInt(index_string);
                    Item item = hero.getConsumables_inventory().get(index);
                    //**********************************
                    if (item instanceof Spell) {
                        if (hero.getSpellMana(index) > hero.getMana()) {
                            PrintPrompt.Print_spell_cannot_use();
                            continue;
                        }
                        String Monster_index_string = AskPrompt.ask_Monster(hero_party, monster_party); // ask player which monster should attack
                        if (Monster_index_string.equals("Q")|Monster_index_string.equals("q")) {//quit
                            player.Quit();
                            return;
                        } else if (Monster_index_string.equals("L")|Monster_index_string.equals("l")) continue; // ao back to choose action
                        Monster monster = (Monster) monster_party.getCharacter(Integer.parseInt(Monster_index_string)); //get monster
                        hero.useSpell(monster, index); //use spell
                        hero_party.updateCharacterBYSearch(hero); // update hero party

                        if (!monster.checkAlive()) {
                            hero_party.gainMoneyExp(monster.getDeadGold(), monster.getDeadExp(1));
                            monster_party.remove(monster);
                        }
                        return;

                    } else if (item instanceof Potions) {
                        Potions potion = (Potions) item;
                        potion.consume(hero); // use Potion
                        hero_party.updateCharacterBYSearch(hero); // update hero party
                        return;
                    }

                    break;
                }
            }

        }
        return ;
    }

    public void startHeroTurn(){ // hero turn
        System.out.println(">>>>>>>>>>> Heroes' Turn start <<<<<<<<<<<<");
        for(int i = 0; i < hero_party.size() && !player.checkQuit(); i++){ // not quit
            Hero next_hero = (Hero) hero_party.getCharacter(i);
            Hero_do_action(next_hero);
            if(checkWin()) return;
        }
    }

    public void startMonsterTurn(){// monster turn
        System.out.println(">>>>>>>>>>> Monster's Turn start <<<<<<<<<<<<");
        for(int i = 0; i < monster_party.size(); i++){
            Monster monster = (Monster) monster_party.getCharacter(i);
            Hero be_attacked = (Hero) hero_party.getCharacter(RandomGenerator.RandomIndex(hero_party.size()));
            // randomly attack a hero
            monster.attack(be_attacked);
            if (!be_attacked.checkAlive()){ //if dead
                hero_party.remove(be_attacked); // kick out from hero party
                dead_pool.add(be_attacked);
            }
        }
    }
    public void HP_MP_regain(){
        for(int i = 0; i < hero_party.size(); i++){
            Hero hero = (Hero) hero_party.getCharacter(i);
            hero.HPregain();
            hero.MPregain();
        }
        System.out.println();
    }

    public boolean checkWin(){
        if(hero_party.empty() || monster_party.empty()){ // return true if the battle is over
            return true;
        }
        return false;
    }
}
