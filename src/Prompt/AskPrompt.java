package Prompt;
import Characters.Monsters.Monster;
import Maps.Map;
import Utility.Scanner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Items.Item;
import Party.Party;
import Characters.Heros.Hero;




public class AskPrompt { // this class is used to communicate with player and terminal
    private static Scanner s = new Scanner();

//    public static int ask_how_many_heroes(int max_people) { // ask how many people is in the party
//        while (true) {
//            System.out.print("How many Heroes will be in your party: ");
//            String num = s.ScanString();
//            try {
//                Integer.parseInt(num);
//            } catch (Exception e) {
//                System.out.println("invalid input! please input a integer\n");
//                continue;
//            }
//            int hero_num = Integer.parseInt(num);
//            if (hero_num > 0 && hero_num <= 3) {
//                //s.close();
//                return hero_num;
//            }
//            System.out.println(String.format("Number of heroes is out of bounds! Only %s people at most", max_people));
//        }
//    }

    public static Hero ask_which_hero(List<Hero> list) { // ask Hero we need to add in the party

        while (true) {
            System.out.print("Which hero you want to select? Enter the number: ");
            String num = s.ScanString();
            try {
                Integer.parseInt(num);
            } catch (Exception e) {
                System.out.println("invalid input! please input a integer\n");
                continue;
            }
            int index = Integer.parseInt(num);
            if (index < list.size() && index >= 0) {
                return list.get(index);
            }
        }
    }

    public static int ask_which_hero_next() { // ask Hero we need to add in the party
        System.out.print("Which hero you want to select? Enter the number: ");
        int num = s.ScanInt();

        while(num<0 || num>2) {
            System.out.println("invalid input! please input a integer\n");
            System.out.print("Which hero you want to select? Enter the number: ");
            num = s.ScanInt();
        }
        return num;
    }

    // Return value for this method is always lower-case.

    public static String ask_which_direction(Hero hero, Map map) { // ask which direction should the party go
        Set<String> valids = new HashSet<>();
        // up, down, left, right
        valids.addAll(Arrays.asList("w", "a", "s", "d"));
        // teleport, recall, use potion, equip/unequip armor/weapon, quit
        valids.addAll(Arrays.asList("t", "r", "p", "e", "q"));
        // enter market if hero is on hero's nexus
        if (map.getCell(hero).isHeroNexus())
            valids.add("m");
        // if monster in range...
        Monster monster = map.monsterInRange(hero);
        if (monster != null)
            // attack, use spell
            valids.addAll(Arrays.asList("at", "sp"));
        while (true) {
            PrintPrompt.printCommands(hero, map);
            String dir = s.ScanString().toLowerCase();
            if (valids.contains(dir)) {
                return dir;
            } else if (dir.equals("i"))
                System.out.print(hero); // if the input is I print information
            else System.out.println("Please enter a valid direction !");
        }
    }

    public static String ask_hero_to_buy(Hero hero) { // return the index of the hero that the player select
        System.out.print(hero);
        while (true) {
            System.out.println("[I/i]: hero info");
            System.out.println("[L/l]: leave the market");
            System.out.println("[Q/q]: quit");
            //System.out.print("Which hero wants to buy/sell some Items? Please enter a number:");
            String index = s.ScanString();
            if (index.equals("I")|index.equals("i")) {
                System.out.print(hero); // if input is I, print party
                continue;
            } else if (index.equals("Q") || index.equals("L")||index.equals("q") || index.equals("l")) {
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
        }
    }

    public static String ask_want_to_buy(List<Item> market_items, Hero hero) {
        PrintPrompt.Print_items(market_items);
        while (true) { // ask player which item they want to buy
            System.out.println(String.format("Which item do %s wants to buy? current remain money %s", hero.getName(), hero.getMoney()));
            System.out.println("If you don't want to buy, press [L/l]: leave, [I/i] see all items. Please Enter the number:");
            System.out.println("[L/l]: leave");
            System.out.println("[I/i] see all items");
            System.out.print("Please Enter the number: ");

            String index = s.ScanString();
            if (index.equals("I")|index.equals("i")) { // quit
                PrintPrompt.Print_items(market_items);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < market_items.size()) {
                return index;
            }
            System.out.println("Please select a item again");
        }
    }

    public static String ask_keep_shopping(Hero hero) {
        while (true) {// ask the player if they want to keep shopping or not
            System.out.println(String.format("Does %s still have items to buy?", hero.getName()));
            System.out.println("[S/s] stay in the market");
            System.out.println("[L/l] leave. Please enter:");
            System.out.print("Please enter: ");
            String input = s.ScanString();
            if (input.equals("S") || input.equals("L") || input.equals("Q") || input.equals("s") || input.equals("l") || input.equals("q")) {
                return input;
            } else System.out.println("Please enter a valid input!");
        }
    }

    public static String ask_Heros_turn(Hero hero, Party party, Party Monster_party) { // ask the hero what he wants to do
        System.out.println(String.format("=================%s's turn=======================", hero.getName()));
        while (true) {
            System.out.println(String.format("It's %s's turn! What would %s want to do?", hero.getName(), hero.getName()));
            System.out.println("[A/a] attack");
            System.out.println("[S/s] Use Spells & Potions");
            System.out.println("[E/e] equip");
            System.out.println("[I/i] Party info");
            System.out.println("[MI] Monster info");
            System.out.println("[Q/q] Quit Game");
            System.out.print("Please Enter: ");
            String input = s.ScanString();
            if (input.equals("A") || input.equals("S") || input.equals("E") || input.equals("Q")
            || input.equals("a") || input.equals("s") || input.equals("e") || input.equals("q")) {
                return input;
            } else if (input.equals("I") || input.equals("i")) {
                System.out.print(party);
            } else if (input.equals("MI")) {
                System.out.print(Monster_party);
            } else System.out.println("Please enter a valid input!");
        }
    }

    public static void ask_teleport(){
        System.out.println("Where do you want to teleport?");
        System.out.println("please enter the position(x, y)?");
    }

    public static String ask_equip(Hero hero, List<Item> equipments) { //ask player which equipment should the hero equip?
        if (equipments.isEmpty()) { // when the list is empty
            System.out.println("There is no items that can be equiped!!!");
            return "L";
        }
        System.out.println(String.format("\n Here are equipments %s have: ", hero.getName()));
        PrintPrompt.Print_items(equipments);
        while (true) {
            System.out.println(String.format("Which equipment should %s equip?", hero.getName()));
            System.out.println("[I/i] info");
            System.out.println("[L/l] leave");
            System.out.println("[Q/q] quit");
            System.out.print("Please Enter the number: ");
            String index = s.ScanString();
            if (index.equals("I") || index.equals("i")) { // quit
                PrintPrompt.Print_items(equipments);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < equipments.size()) {
                return index;
            }
            System.out.println("Please select a item again");
        }
    }

    public static String ask_Monster(Party party, Party monster_party) { //ask player which monster should the hero attack?
        if (monster_party.empty()) { // when the list is empty
            System.out.println("Monsters are all died!!!");
            return "L";
        }
        System.out.println(String.format("Here are the Monsters"));
        System.out.print(monster_party);
        while (true) {
            System.out.println(String.format("Choose a monster to attack"));
            System.out.println("[MI] monster info");
            System.out.println("[L/l] choose another action");
            System.out.println("[Q/q] quit game");
            System.out.print("Please Enter the number: ");
            String index = s.ScanString();
            if (index.equals("MI")) { // quit
                System.out.print(monster_party);
                continue;
            } else if (index.equals("I") || index.equals("i")) { // quit
                System.out.print(party);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < monster_party.size()) {
                return index;
            }
            System.out.println("Please select a monster again");
        }
    }

    public static String ask_which_potion_spell(Hero hero, List<Item> Consumables) { //ask which potion or spell the player wants to use in a battle
        if (Consumables.isEmpty()) { // when the list is empty
            System.out.println("There is no Spell/Potion that can be used!!!");
            return "L";
        }
        System.out.println(String.format("\nHere are %s have: ", hero.getName()));
        PrintPrompt.Print_items(Consumables);
        while (true) {
            System.out.println(String.format("Which Spell/Potion should %s use?", hero.getName()));
            System.out.println("[I/i] info");
            System.out.println("[L/l] leave");
            System.out.println("[Q/q] quit");
            System.out.print("Please Enter the number: ");
            String index = s.ScanString();
            if (index.equals("I") || index.equals("i")) { // quit
                PrintPrompt.Print_items(Consumables);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < Consumables.size()) {
                return index;
            }
            System.out.println("Please select a item again");
        }
    }



    public static String ask_which_potion(Hero hero, List<Item> potion) { //ask which potion or spell the player wants to use in a battle
        if (potion.isEmpty()) { // when the list is empty
            System.out.println("There is no Potion that can be used!!!");
            return "L";
        }
        System.out.println(String.format("\nHere are %s have: ", hero.getName()));
        PrintPrompt.Print_items(potion);
        while (true) {
            System.out.println(String.format("Which Potion should %s use?", hero.getName()));
            System.out.println("[I/i] info");
            System.out.println("[L/l] leave");
            System.out.println("[Q/q] quit");
            System.out.print("Please Enter the number: ");
            String index = s.ScanString();
            if (index.equals("I") || index.equals("i")) { // quit
                PrintPrompt.Print_items(potion);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < potion.size()) {
                return index;
            }
            System.out.println("Please select a item again");
        }
    }

    public static String ask_which_spell(Hero hero, List<Item> spell) { //ask which potion or spell the player wants to use in a battle
        if (spell.isEmpty()) { // when the list is empty
            System.out.println("There is no Spell that can be used!!!");
            return "L";
        }
        System.out.println(String.format("\nHere are %s have: ", hero.getName()));
        PrintPrompt.Print_items(spell);
        while (true) {
            System.out.println(String.format("Which Spell should %s use?", hero.getName()));
            System.out.println("[I/i] info");
            System.out.println("[L/l] leave");
            System.out.println("[Q/q] quit");
            System.out.print("Please Enter the number: ");
            String index = s.ScanString();
            if (index.equals("I") || index.equals("i")) { // quit
                PrintPrompt.Print_items(spell);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < spell.size()) {
                return index;
            }
            System.out.println("Please select a item again");
        }
    }

    public static String ask_buy_sell(Hero hero) {
        while (true) {
            System.out.println(String.format("What would %s want to do?", hero.getName(), hero.getName()));
            System.out.println("[A/a] buy items");
            System.out.println("[S/s] sell items");
            System.out.println("[L/l] leave");
            System.out.print("Please Enter: ");
            String input = s.ScanString();
            if (input.equals("A") || input.equals("a") || input.equals("L") || input.equals("l")) {
                return input;
            } else if (input.equals("S") || input.equals("s")) {
                if (hero.getEquipment_inventory().isEmpty() && hero.getConsumables_inventory().isEmpty()) {
                    System.out.println("The Hero do not have items to sell!");
                    continue;
                } else return input;
            } else {
                System.out.println("Please use a valid input!!");
            }

        }
    }

    public static String ask_item_to_sell(Hero hero, List<Item> item_list) {
        if (item_list.isEmpty()) { // when the list is empty
            System.out.println("There is no items that can be sell!!!");
            return "L";
        }
        System.out.println(String.format("\nHere are %s have: ", hero.getName()));
        PrintPrompt.Print_items(item_list);
        while (true) {
            System.out.println(String.format("Which items should be sold?"));
            System.out.println("[I/i] info");
            System.out.println("[L/l] leave");
            System.out.println("[Q/q] quit");
            System.out.print("Please Enter the number: ");
            String index = s.ScanString();
            if (index.equals("I") || index.equals("i") ) { // quit
                PrintPrompt.Print_items(item_list);
                continue;
            } else if (index.equals("Q") || index.equals("L") || index.equals("q") || index.equals("l")) { // quit the game
                return index;
            } else {
                try {
                    Integer.parseInt(index);
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }
            }
            int index_int = Integer.parseInt(index);
            if (0 <= index_int && index_int < item_list.size()) {
                return index;
            }
            System.out.println("Please select a item again");
        }
    }

    public static void close() {
        s.close();
    }
}


