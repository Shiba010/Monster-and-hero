package Items;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Items.Spells.Spell;
import Items.Spells.FireSpell;
import Items.Spells.IceSpell;
import Items.Spells.LighteningSpell;
import Utility.*;

public class ItemFactory { // this class is used to create items
    static private FileReader file;
    static private final List<Item> item_list = new ArrayList<Item>();

    public ItemFactory() throws FileNotFoundException {
        file = new FileReader();
        createFileItems();
    }
    // this function is used to create weapon
    static public Weaponry getWeapon(String name, int price, int level, int damage, int requireHand){
        return new Weaponry( name, price, level, damage, requireHand);
    }
    // used to read and create weapon from file.
    public Weaponry getFileWeapon() throws FileNotFoundException {
        String next_line_weapon = file.read_next_weapon();
        if(!next_line_weapon.equals("file_end")){
            String weapon_data[] = next_line_weapon.split("\\s+");
            return getWeapon(weapon_data[0], Integer.parseInt(weapon_data[1]), Integer.parseInt(weapon_data[2]), Integer.parseInt(weapon_data[3]), Integer.parseInt(weapon_data[4]));
        }
        return null;
    }
    // this function is used to create armor
    public Armory getArmor(String name, int price, int level, int reduction){
        return new Armory(name, price, level, reduction);
    }
    // used to read and create armor from file.
    public Armory getFileArmor() throws FileNotFoundException {
        String next_line_armor = file.read_next_armor();
        if(!next_line_armor.equals("file_end")){
            String armor_data[] = next_line_armor.split("\\s+");
            return getArmor(armor_data[0], Integer.parseInt(armor_data[1]), Integer.parseInt(armor_data[2]), Integer.parseInt(armor_data[3]));
        }
        return null;
    }
    // this function is used to create potion
    public Potions getPotion(String name, int price, int level, int attribute_increase, List<String> attributes){
        return new Potions(name, price, level, attribute_increase, attributes);
    }
    // used to read and create potion from file.
    public Potions getFilePotion(){
        String next_line_potion = file.read_next_potion();
        if(!next_line_potion.equals("file_end")){
            String potion_data [] = next_line_potion.split("\\s+");
            List<String> attributes = new ArrayList<String>(Arrays.asList(potion_data[4].split("/"))); // read attributes as list
            return getPotion(potion_data[0], Integer.parseInt(potion_data[1]), Integer.parseInt(potion_data[2]), Integer.parseInt(potion_data[3]), attributes);
        }
        return null;
    }
    public Spell getSpell(String name, int price, int level, int damage, int mana_cost, String type){ // generate different type of spell
        if(type.equals("FireSpell")){
            return new FireSpell(name, price, level, damage, mana_cost, type);
        }
        else if(type.equals("IceSpell")){
            return new IceSpell(name, price, level, damage, mana_cost, type);
        }
        else if(type.equals("LightingSpell")){
            return new LighteningSpell(name, price, level, damage, mana_cost, type);
        }
        return null;
    }
    public Spell getFileSpell(){
        String next_line_spell = file.read_next_spell();
        if(!next_line_spell.equals("file_end")){
            String spell_data[] = next_line_spell.split("\\s+");
            return getSpell(spell_data[0], Integer.parseInt(spell_data[1]), Integer.parseInt(spell_data[2]), Integer.parseInt(spell_data[3]), Integer.parseInt(spell_data[4]), spell_data[5]);
        }
        return null;
    }

    public void createFileItems() throws FileNotFoundException {
        // return a list of items that is read from file to Market
        while(true){
            Weaponry weapon = getFileWeapon();
            if(weapon == null) break;
            item_list.add(weapon);
        }
        //create Armors
        while(true){
            Armory arm = getFileArmor();
            if(arm == null) break;
            item_list.add(arm);
        }
        //create potions
        while (true){
            Potions potions = getFilePotion();
            if(potions == null) break;
            item_list.add(potions);
        }
        //create Spells
        while (true){
            Spell spell = getFileSpell();
            if(spell == null) break;
            item_list.add(spell);
        }
    }
    public static List<Item> getItem_list() { // return item list
        return item_list;
    }

    public static void main(String[] args) throws FileNotFoundException { // for test
        ItemFactory factory = new ItemFactory();
        while(true){
            Spell s = factory.getFileSpell();
            if(s == null) break;
            System.out.print(s);
        }
    }
}

