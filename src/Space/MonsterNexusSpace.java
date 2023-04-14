package Space;


public class MonsterNexusSpace extends Cell { //this is the class for the nexus of monster
    public MonsterNexusSpace() {
        super();
    }

    @Override
    public boolean isMonsterNexus() {
        return true;
    }

    @Override
    public String rep() {
        return "N";
    }
}
