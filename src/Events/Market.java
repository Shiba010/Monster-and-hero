package Events;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Players.Player;
import Items.*;
import Maps.RandomGenerator;
import Characters.Heros.Hero;
import Prompt.*;




public class Market implements Event{
    private List<Item> item_list = new ArrayList<Item>();

    public Market() {
        item_list = ItemFactory.getItem_list();
    }

    public void PrintItems(){
        PrintPrompt.Print_items(item_list);
    }

    //public Hero enterMarket(Player player, int index){ // index means which Hero is going to enter Market
    public Hero enterMarket(Hero hero){ // index means which Hero is going to enter Market
        //Hero hero = player.getCharacter(index);
        System.out.println(hero.getName()+" goes in to Market!");
        PrintPrompt.welcome_market();
        Player player = new Player();

        label:
        while(!player.checkQuit()){
            String buy_cell = AskPrompt.ask_buy_sell(hero);
            switch (buy_cell) {

                case ("A"):
                case ("a"):
                    break label;
                case "S":  // if the player choose to sell
                case "s":
                    List<Item> item_list = new ArrayList<Item>();
                    item_list.addAll(hero.getConsumables_inventory());
                    item_list.addAll(hero.getEquipment_inventory());
                    String item_index = AskPrompt.ask_item_to_sell(hero, item_list); // return the index that need to be sold

                    if (item_index.equals("Q")|item_index.equals("q")) {
                        player.Quit();
                        return hero;
                    } else if (item_index.equals("L")|item_index.equals("l")) {
                        return hero;
                    } else {
                        Item item = item_list.get(Integer.parseInt(item_index));// get the item that need to be sold

                        hero.sell(item);
                        this.item_list.add(item);
                        //player.updateParty(index, hero);
                        return hero;
                    }
                case "L":
                case "l":
                    return hero;
            }
        }

        while(!player.checkQuit()){ // if quit is not true
            String item_index_string = AskPrompt.ask_want_to_buy(item_list, hero);
            if(item_index_string.equals("L") || item_index_string.equals("l")){ // hero leave the market
                return hero;
            }
            else if(item_index_string.equals("Q") || item_index_string.equals("q")){ // quit
                player.Quit();
                return hero;
            }
            int item_index = Integer.parseInt(item_index_string); // item_index
            if(hero.CheckBuy(item_list.get(item_index))){ // if the item can be bought
                hero.buy(item_list.remove(item_index)); // buy it
                //player.updateParty(index,hero); // update the data in party
            }
            String keep = AskPrompt.ask_keep_shopping(hero);
            if(keep.equals("L") || keep.equals("l")){ // leave
                return hero;
            }
            else if (keep.equals("Q") || keep.equals("q")){ // quit
                player.Quit();
                return hero;
            }
        }
        return hero;
    }

    @Override
    public boolean event_occur(double probability) {
        return RandomGenerator.TrueFalseGen(probability);
    }


    public Hero start_event(Hero hero) {
        Player player = new Player();
        while(!player.checkQuit()){ // if quit is not true
            String input = AskPrompt.ask_hero_to_buy(player.getParty()); // return a string represent index or I or Q;
            if(input.equals("Q") || input.equals("q")) { // quit if the player type Q
                player.Quit();
                return hero;
            }
            else if(input.equals("L") || input.equals("l")){ // leave the market
                return hero;
            }
            //int index = Integer.parseInt(input); // change to integer
            hero = enterMarket(hero);// decide which hero will enter to market
        }
        return hero;
    }
    @Override
    public Player start_event(Player player){
        return player;
    };


}
