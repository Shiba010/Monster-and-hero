package Characters.Monsters;
import Characters.Character;

public class Exoskeleton extends Monster implements Character{ //this is the class for exoskeleton
    public Exoskeleton(String name, int level, int damage, int defense, int dodge_abi) {
        super(name, level, damage, defense, dodge_abi);
    }

}