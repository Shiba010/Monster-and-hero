package Characters;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Party.Party;
import Maps.RandomGenerator;
import Characters.Heros.Hero;
import Characters.Heros.Paladin;
import Characters.Heros.Warrior;
import Characters.Heros.Sorcerer;
import Characters.Monsters.Monster;
import Characters.Monsters.Dragon;
import Characters.Monsters.Exoskeleton;
import Characters.Monsters.Spirit;
import Prompt.*;
import Utility.FileReader;


public class CharacterFactory {

    private static class MonsterGenerator {
        private String name;
        private int level;
        private int HP;
        private int base_damage;
        private int defense_val;
        private int dodge_ability;
        private String type;

        public MonsterGenerator(String name, int level, int damage, int defense, int dodge_abi, String type) {
            this.name = name;
            this.level = level;
            this.base_damage = damage;
            this.defense_val = defense;
            this.dodge_ability = dodge_abi;
            this.type = type;
        }

        public Monster generateMonster() {
            switch (type) {
                case "Dragon":
                    return new Dragon(name, level, base_damage, defense_val, dodge_ability);
                case "Exoskeleton":
                    return new Exoskeleton(name, level, base_damage, defense_val, dodge_ability);
                case "Spirit":
                    return new Spirit(name, level, base_damage, defense_val, dodge_ability);
                default:
                    return null;
            }
        }

        public int getLevel() {
            return level;
        }
    }

    private static FileReader file;
    private static final List<Hero> Hero_list = new ArrayList<Hero>();
    private static final List<MonsterGenerator> Monster_list = new ArrayList<>();

    public CharacterFactory() throws FileNotFoundException {
        file = new FileReader();
        createHero_list();
        createMonsterList();
    }

    public static Hero getHero(String name, int mana, int str, int agi, int dex, int money, int exp, String type) { // create heroes
        switch (type) {
            case "Warrior":
                return new Warrior(name, mana, str, agi, dex, money, exp);
            case "Sorcerer":
                return new Sorcerer(name, mana, str, agi, dex, money, exp);
            case "Paladin":
                return new Paladin(name, mana, str, agi, dex, money, exp);
        }
        return null;
    }

    public static Hero getFileHero() { // get hero
        String Hero_next_line = file.read_next_Hero();
        if (!Hero_next_line.equals("file_end")) {
            String Hero_data[] = Hero_next_line.split("\\s+");
            return getHero(Hero_data[0], Integer.parseInt(Hero_data[1]), Integer.parseInt(Hero_data[2]), Integer.parseInt(Hero_data[3]), Integer.parseInt(Hero_data[4]), Integer.parseInt(Hero_data[5]), Integer.parseInt(Hero_data[6]), Hero_data[7]);
        }
        return null;
    }

    private static MonsterGenerator getMonster(String name, int level, int damage, int defense, int dodge_abi, String type) { // create a monster
        return new MonsterGenerator(name, level, damage, defense, dodge_abi, type);
    }

    private static MonsterGenerator getFileMonster() { // get monster from file
        String Monster_next_line = file.read_next_monster();
        if (!Monster_next_line.equals("file_end")) {
            String monster_data[] = Monster_next_line.split("\\s+");
            return getMonster(monster_data[0], Integer.parseInt(monster_data[1]), Integer.parseInt(monster_data[2]), Integer.parseInt(monster_data[3]), Integer.parseInt(monster_data[4]), monster_data[5]);
        }
        return null;
    }

    public static void createHero_list() {
        while (true) {
            Hero h = getFileHero();
            if (h == null) break;
            Hero_list.add(h);
        }
    }

    public static List getHeroList() {
        return Hero_list;
    }

    public static void PrintHeroList() { // print out the list of heroes that read from file
        PrintPrompt.Print_heroes(Hero_list);
    }

    public static void createMonsterList() { // create a list that contain all the monsters
        while (true) {
            MonsterGenerator m = getFileMonster();
            if (m == null) break;
            Monster_list.add(m);
        }
    }

    public static Party getMonsterParty(int level, int num_heroes) {
        if (level > 10) level = 10; // max level of monster is 10
        List<Monster> monsterList_lev = new ArrayList<Monster>(); // list of monsters that have same level of Heroes
        for (MonsterGenerator m : Monster_list) {
            if (m.getLevel() == level) {
                monsterList_lev.add(m.generateMonster()); // add all the same level monster to the list
            }
        }
        Party monster_party = new Party(); // monster party
        for (int i = 0; i < num_heroes; i++) {
            Monster m = monsterList_lev.remove(RandomGenerator.RandomIndex(monsterList_lev.size())); //
            monster_party.addMember(m);
        }
        return monster_party;
    }
}
