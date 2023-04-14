package Players;
import Party.Party;
import Characters.Heros.Hero;
import Characters.Character;

public class Player { //this is the class for do operation on party
    private Party party = new Party();
    private boolean quit = false;


    public boolean checkQuit(){
        return quit;
    }
    public void Quit(){
        System.out.print("Quit the game!\n Game OVer!!!\n");
        quit = true;
    }
    public void addHeroToParty(Hero hero){
        party.addMember(hero);
    }
    public boolean checkPartMember(Character c){
        return party.checkMember(c);
    }
    public Party getParty(){
        return party;
    }
    public void updateParty(int index, Character c){
        party.updateCharacter(index, c);
    }
    public Hero getCharacter(int index){ // return Hero by index
        return (Hero) party.getCharacter(index);
    }

}
