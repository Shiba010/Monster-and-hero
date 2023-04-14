package Prompt;
import Characters.Monsters.Monster;
import Items.Equipable;
import Items.Item;
import Items.Weaponry;
import Items.Potions;
import Items.Spells.Spell;
import Items.Armory;
import Party.Party;
import Maps.Map;
import Characters.Heros.Hero;
import Characters.Heros.Paladin;
import Characters.Heros.Warrior;
import Characters.Heros.Sorcerer;
import Characters.Character;
import java.util.List;


public class PrintPrompt {
    public static void levelUpPrint(Character c){
        System.out.println("WoW!!!! "+ c.getName()+ " level up ! "+ c.getName() + " is now level " +c.getLevel()+"\n");
    }
    public static void attactPrint(Character a, Character b, int damage){ // a attack b
        System.out.println(a.getName()+ " attacks "+b.getName()+ " and causes " + damage +" damage!");
        System.out.println(b.getName() + " now has only left "+ b.getHP()+ " HP \n");
    }
    public static void dodgePrint(Character a, Character b){
        System.out.println(a.getName() + " attacks " + b.getName());
        System.out.println(b.getName() + " successfully dodges\n");
    }
    public static void deadPrint(Character c){
        System.out.println(c.getName()+ " is dead >.<");
    }

    public static void equipable_element_Print(List<Equipable> inventory){
        for(Equipable e : inventory){
            System.out.print(e);
        }
    }
    public static void remove_equipment_print(Character c, Item e){
        System.out.println(c.getName() + " removes " + e.getname() +"to bags");
    }
    public static void equip_print(Character c, Item e){
        System.out.println(c.getName() + " equips " + e.getname());
    }
    public static void cannot_move(){
        System.out.println("You cannot move here, please select another direction.");
    }
    public static void gain_exp_money_print(Character c, int money, int exp){
        System.out.println(String.format("%s gains %s gold and %s exp ",c.getName(),money,exp));
    }
    public static void Print_start_game(){
        System.out.println("Welcome to Heroes and Monsters RPG game");
    }
    public static void already_in_party(Character c){
        System.out.println(c.getName()+" is already in the party!!");
    }
    public static void join_party(Character c){
        System.out.println(c.getName()+" is joined to the party!!");
    }
    public static void each_round_begin(Party party, Map map){
        System.out.print(map);
        System.out.print("This is your party: \n" + party.toString());
//        System.out.println("H is your hero location on the map: ");
    }

    public static void invalidTeleport(){
        System.out.println("Invalid teleport! Please try again.");
    }
    public static void invalidRecall(){
        System.out.println("Invalid Recall.");
    }




    public static void Print_heroes(List<Hero> Hero_list){ // print heroes list, for player to select heroes
        String title = String.format("   %-25s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Name", "HP", "level","mana","str","agi","dex","money","exp");
        String Warriors_out = "Here are warriors:\n" + title;
        String Sorcerers_out = "Here are sorcerers:\n"+ title;
        String Paladins_out = "Here are paladins:\n"+ title;
        for(int i = 0; i < Hero_list.size(); i++){
            Hero h = Hero_list.get(i);
            if(h instanceof Warrior){
                Warriors_out += String.format("[%2s] " + h ,i);
            }
            else if (h instanceof Sorcerer) {
                Sorcerers_out += String.format("[%2s] " + h ,i);
            }
            else if (h instanceof Paladin) {
                Paladins_out += String.format("[%2s] " + h,i);
            }
        }
        System.out.print(Warriors_out+"\n"+Sorcerers_out+"\n"+Paladins_out+"\n");
    }
    public static void Print_item_cannot_buy(Item items){
        System.out.println("\n*****The hero can't buy "+items.getname()+" because of insufficient money or level*****\n");
    }
    public static void Print_spell_cannot_use(){
        System.out.println("***** this spell can not use because the mana is not enough*****");
    }
    public static void welcome_market(){
        System.out.println("*************************************************");
        System.out.println("**           Welcome to the Market             **");
        System.out.println("*************************************************");
    }
    public static void welcome_game(){
        System.out.println("*************************************************");
        System.out.println("**       Welcome to the Heroes & Monsters      **");
        System.out.println("*************************************************");
    }


    public static void Print_items(List<Item> item_list){
        boolean existWeapon= false, existArmor= false, existPotion= false, existSpell = false;
        String Weapons_print = "Here are Weapons: \n"+
                String.format("     %-10s %-10s %-10s %-15s %-10s\n",
                        "name", "price", "level", "damage_val", "requireHands");

        String Armors_print = "Here are Armors: \n" +
                String.format("     %-20s %-10s %-10s %-10s\n", "name", "price", "level", "reduction");

        String Potion_print = "Here are Potions: \n" +
                String.format("     %-20s %-10s %-10s %-20s %-10s\n",
                        "name", "price", "level", "attribute_increase", "attributes");
        String Spell_print = "Here are Spells: \n" +
                String.format("     %-20s %-10s %-10s %-10s %-10s %-10s\n", "name", "price", "level", "damage", "mana_cost", "spellType");
        for(int i = 0; i < item_list.size(); i++){
            Item item = item_list.get(i);
            if(item instanceof Weaponry) {
                existWeapon =true;
                Weapons_print += String.format("[%2s] " + item ,i);
            }
            if(item instanceof Armory) {
                existArmor = true;
                Armors_print += String.format("[%2s] " + item ,i);
            }
            if(item instanceof Potions) {
                existPotion = true;
                Potion_print += String.format("[%2s] " + item ,i);
            }
            if(item instanceof Spell) {
                existSpell = true;
                Spell_print += String.format("[%2s] " + item ,i);
            }
        }
        String out="";
        if(existWeapon) out += (Weapons_print+"\n");
        if(existArmor) out += (Armors_print+"\n");
        if(existPotion) out += (Potion_print+"\n");
        if(existSpell) out += (Spell_print+"\n");
        System.out.print(out);
    }

    public static void Print_equipable(List<Item> item_list){ // print equipable items
        String Weapons_print = "Here are Weapons: \n"+
                String.format("     %-10s %-10s %-10s %-15s %-10s\n",
                        "name", "price", "level", "damage_val", "requireHands");
        String Armors_print = "Here are Armors: \n" +
                String.format("     %-20s %-10s %-10s %-10s\n", "name", "price", "level", "reduction");
        for(int i = 0; i < item_list.size(); i++){
            Item item = item_list.get(i);
            if(item instanceof Weaponry) {
                Weapons_print += String.format("[%2s] " + item ,i);
            }
            if(item instanceof Armory) {
                Armors_print += String.format("[%2s] " + item ,i);
            }

        }
        System.out.print(Weapons_print+"\n"+Armors_print+"\n");
    }
    public static void Print_battle_start(Party party, Party Monster_party){
        System.out.println("Your party encounter a group of Monster!!!!");
        System.out.println("*************** Battle Begin ! *****************");
        System.out.println("This is your party: ");
        System.out.print(party);
        System.out.println("Here are Monsters: ");
        System.out.print(Monster_party);
    }
    public static void Print_buy(Hero hero, Item item){
        System.out.println(String.format("%s successfully spent %s dollar on %s", hero.getName(), item.getprice(),item.getname()));
    }

    public static void handleQuit() {
        System.out.println("Now quitting.");
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    public static void printCommands(Hero hero, Map map) {
        System.out.println("What will " + hero.getName() + " (" + hero.getHeroMark() + ") do?");
        System.out.println("COMMANDS: ");
        System.out.print("[W/w] up; ");
        System.out.print("[A/a] left; ");
        System.out.print("[S/s] down; ");
        System.out.println("[D/d] right");

        System.out.print("[T/t] teleport; ");
        System.out.print("[R/r] recall; ");
        System.out.print("[P/p] use potion; ");
        System.out.print("[E/e] equip weapon or armor; ");

        System.out.print("[I/i] info; ");
        System.out.print("[Q/q] quit\n");
        // if hero is in nexus, show command for market
        if(map.getCell(hero).isHeroNexus())
            System.out.println("[M/m] Market");
        // if monster in hero's range, show attack commands
        Monster monster = map.monsterInRange(hero);
        if (monster != null) {
            System.out.println("[At] attack the monster");
            System.out.println("[Sp] use spell on monster");
        }

    }
}
