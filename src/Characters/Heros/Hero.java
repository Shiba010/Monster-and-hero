package Characters.Heros;
import java.util.ArrayList;
import java.util.List;
import Characters.Character;
import Characters.CharacterFactory;
import Items.Item;
import Items.Weaponry;
import Items.Armory;
import Items.Consumable;
import Items.Equipable;
import Items.Potions;
import Items.Spells.Spell;
import Prompt.PrintPrompt;
import Maps.RandomGenerator;
import Characters.Monsters.Monster;
import Players.Player;
import Party.Party;




abstract public class Hero implements Character{  // this class is Hero object
    private String name;
    private int HP;
    private int level;
    private int mana;
    private int str; //strength
    private int agi; //agility
    private int dex; //dexterity
    private int money;
    private int exp;
    private String heroMark;
    private int positionX;
    private int positionY;
    private final List<Item> equipment_inventory = new ArrayList<Item>(); // inventory that only contains equipment
    private final List<Item> consumables_inventory = new ArrayList<Item>(); // inventory that only contains consumable
    private final List<Item> potion_inventory = new ArrayList<Item>();
    private final List<Item> spell_inventory = new ArrayList<Item>();

    private Weaponry weapon; // equipment is weapon that is on hero's hand
    private Armory Arm = null; // Armory on hero
    private boolean move; // if the hero has moved in a battle, this will be true;
    private final int level_up_factor; // this is used to set how much experience a hero can level up
    // if the hero's level is 2, he need 10*2 = 20 exp to level up;
    private final double skill_increase_factor; // 5%
    private final int level_HP_ratio;
    private final double level_mana_ratio;
    private final double attack_factor;
    private final double dodge_factor;
    private final double HP_regain_factor;
    private final double MP_regain_factor;
    private final double dex_damage_factor;


    public Hero(String name, int mana, int str, int agi, int dex, int money, int exp){
        level_up_factor = 10;
        skill_increase_factor = 0.05;
        level_HP_ratio = 100;
        level_mana_ratio = 1.1;
        attack_factor = 0.05;
        dodge_factor = 0.0002;
        HP_regain_factor = 1.1;
        MP_regain_factor = 1.1;
        dex_damage_factor = 10000;
        this.name = name;
        this.mana = mana;
        this.str = str;
        this.agi = agi;
        this.dex = dex;
        this.money = money;
        this.exp = exp;
        this.level = 1;
        this.HP = Math.round(level*level_HP_ratio); // reset HP
    }

    public boolean CheckBuy(Item item){ // check the item can be bought or not
        int item_price = item.getprice();
        int item_level = item.getlevel();
        if(item_price > money || level < item_level){ // don't have enough money or item's level is too high
            PrintPrompt.Print_item_cannot_buy(item);
            return false;
        }
        return true;
    }

    public void buy(Item item){ //buy item
        PrintPrompt.Print_buy(this, item);
        money -= item.getprice();
        if(item instanceof Equipable){
            equipment_inventory.add(item);
        }
        else if (item instanceof Consumable){
            consumables_inventory.add(item);
        }

        if (item instanceof Potions) {
            potion_inventory.add(item);
        }
        if (item instanceof Spell) {
            spell_inventory.add(item);
        }
    }

    public void sell(Item item){
        System.out.println(String.format("\n**********%s sells %s**********\n",name,item.getname()));
        if(item instanceof Equipable){
            equipment_inventory.remove(item);
        }
        else if (item instanceof Consumable) {
            consumables_inventory.remove(item);
        }
        gainGold(item.getprice()/2);
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getHP() {
        return HP;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void takeDamage(int damage, Character c) { // lost HP, and check the character is dead or not
        int reduction = 0;
        if(Arm != null){ // if the hero has Armor
            reduction = Arm.getReduction();
        }
        int revise_damage = (int) ((damage - reduction)*attack_factor);
        revise_damage = Math.max(0, revise_damage); // if lower than 0 , return 0
        HP = HP - revise_damage;
        PrintPrompt.attactPrint(c, this , revise_damage);
        if(!checkAlive()){
            dead();
        }
    }
    @Override
    public int getLevel() {
        return level;
    }
    public void levelup(){
        if(checklevelUp()){ //if the character can level up
            exp = exp - level*level_up_factor;
            level++;
            HP = (int) Math.round(level*level_HP_ratio); // reset HP
            mana = (int) Math.round(mana*level_mana_ratio); // increase mana
            PrintPrompt.levelUpPrint(this);
        }
        skill_increase(); // different types of heroes have different favored skills
    }
    abstract public void skill_increase(); // different types of heroes have different favored skills
    public void str_increase(){
        str = (int) Math.round(str * (1+skill_increase_factor));
    }
    public void agi_increase(){
        agi = (int) Math.round(agi * (1+skill_increase_factor));
    }
    public void dex_increase(){
        dex = (int) Math.round(dex * (1+skill_increase_factor));
    }

    public void gainGold(int extra_money){
        money += extra_money;
    }
    public void gainExp(int extra_exp){
        this.exp += extra_exp;
        if(checklevelUp()) { // check if the character can level up after getting exp
            levelup();
        }
    }
    public boolean checklevelUp(){ // if te hero can level up, then return true;
        return exp >= level * level_up_factor;
    }

    @Override
    public void attack(Character c) {
        int tot_weapon_damage = 0;
        if(weapon != null){ // calculate the weapon damage
            tot_weapon_damage = weapon.getDamage_val();
        }
        int damage = (int) (Math.round(str + tot_weapon_damage)*attack_factor);
        if(!c.dodge()) { // if the character fails to dodge
            c.takeDamage(damage , this ); //get damage
        } else{ // successfully dodge
            PrintPrompt.dodgePrint(this, c);
        }
    }
    @Override
    public boolean dodge() {
        double dodge_probability = agi*dodge_factor;
        return RandomGenerator.TrueFalseGen(dodge_probability); // successfully dodge
    }
    @Override
    public boolean checkAlive() { // check the character is alive
        return HP > 0;
    }
    @Override
    public void dead() { // dead
        PrintPrompt.deadPrint(this);
        HP = 0;
    }
    public void equip(int index){ // equip item in the equipment inventory
        Item e = equipment_inventory.remove(index);
        if(e instanceof Weaponry){
            if(weapon != null){
                equipment_inventory.add(weapon); //put e back to inventory
                PrintPrompt.remove_equipment_print(this, e);//print
            }
            weapon = (Weaponry) e;
        }
        else if(e instanceof Armory){
            if(Arm != null){
                equipment_inventory.add(Arm); // put it back
                PrintPrompt.remove_equipment_print(this, e);//print
            }
            Arm = (Armory) e;
        }
        PrintPrompt.equip_print(this, e);
    }
    public void useSpell(Monster monster, Spell spell){ // use spell
        //if(consumables_inventory.get(index) instanceof Spell){ // if the index we choose is a spell
        consumables_inventory.remove(spell);
        spell_inventory.remove(spell);

        mana -= spell.getMana_cost(); // mana lost
        monster.getSpellAffect(spell, this);
        int spell_damage = (int) Math.round(attack_factor*(spell.getDamage() + spell.getDamage()*(dex/dex_damage_factor))); // calculate spell damage
        monster.takeDamage(spell_damage, this ); //get damage
    }
    public int getSpellMana(int index){
        Spell spell = (Spell) spell_inventory.get(index);
        return spell.getMana_cost();
    }
    public void usePotion(Potions potion){
        potion_inventory.remove(potion);
        consumables_inventory.remove(potion);
    }

    public List<Item> getEquipment_inventory() {
        return equipment_inventory;
    }

    public List<Item> getConsumables_inventory() {
        return consumables_inventory;
    }

    public List<Item> getSpell_inventory() {
        return spell_inventory;
    }

    public List<Item> getPotion_inventory() {
        return potion_inventory;
    }


    public void gainMana(int extra_mana){
        System.out.println(this.name+" Mana increase "+extra_mana);
        mana += extra_mana;
    }
    public void gainHP(int hp){
        System.out.println(this.name+" HP increase "+hp);
        HP += hp;
        if(HP > level*level_HP_ratio){ // if it exceeds the upper bound, adjust it
            HP = level*level_HP_ratio;
        }
    }
    public void gainStrength(int extra_str){
        System.out.println(this.name+" Str increase "+extra_str);
        str += extra_str;
    }
    public void gainDex(int extra_dex){
        System.out.println(this.name+" Dex increase "+extra_dex);
        dex += extra_dex;
    }
    public void gainAgi(int extra_agi){
        System.out.println(this.name+" Agi increase "+extra_agi);
        agi += extra_agi;
    }

    public void HPregain(){
        HP = (int) Math.round(HP* HP_regain_factor);
        if(HP > level*level_HP_ratio){
            HP = level*level_HP_ratio;
        }
        System.out.println(name+" regain MP HP");
    }
    public void MPregain(){
        mana = (int) Math.round(mana* MP_regain_factor);
    }


    @Override
    public String toString() {
        String HP_string = HP + "/" + level*level_HP_ratio;
        String exp_string = exp+"/"+level*level_up_factor; // exp 8/10 means when exp = 10, the hero will level up
        String Hero = String.format("%-25s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                name, HP_string, level, mana, str, agi, dex, money, exp_string);
        return Hero;
    }
    @Override
    public String getTitle(){ // Name HP mana str agi dex money exp
        String title = String.format("   %-25s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Name", "HP", "level","mana","str","agi","dex","money","exp");
        return title;
    }

    public void setHeroMark( int index){
        heroMark = "H" + (index + 1);
    }
    public String getHeroMark(){
        return heroMark;
    }
    public void setInitialPosition(int index){
        positionY = 7;
        positionX = (index * 3) + 1;
    }

    public void setPositionX(int positionX){
        this.positionX = positionX;
    }
    public void setPositionY(int positionY){
        this.positionY = positionY;
    }
    @Override
    public int getPositionX(){
        return positionX;
    }
    @Override
    public int getPositionY(){
        return positionY;
    }

    public void revive() {
        HP = level * level_HP_ratio;
        mana = (int) Math.round(level * level_mana_ratio);
        money -= 100;
        money = Math.max(money, 0);
    }
}

