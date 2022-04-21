package Characters;

public class Humans implements Commands {

    private String humanName = ""; // name
    private int humanStrength = 0; // damage
    private int humanStamina = 0; // movement
    private int humanHealth = 0; // hit points
    private int humanLuck = 0; // luck for treasure chest

    public Humans(){

    }
    public Humans(String playername, int playerstrength, int playerstamina,
                  int playerhealth, int playerluck){
        this.humanName = playername;
        this.humanStrength = playerstrength;
        this.humanStamina = playerstamina;
        this.humanHealth = playerhealth;
        this.humanLuck = playerluck;
    }
    public String speak(){
        return "Begone swine!";
    }
    @Override
    public String toString(){
        return this.humanName + " has " + this.humanHealth + " HP left.";
    }

    @Override
    public String attack(Object other){
        var goblins = (Goblins) other;
        goblins.setGoblinHealth(goblins.getGoblinHealth() - this.humanStrength);
        if(goblins.getGoblinHealth() <= 3) {
            return "The goblin bites the human for " + this.humanStrength +
                    " damage, the human has died...";
        }
        return "The zombie bites the human for " + this.humanStrength +
                " damage, the human survives but will be turning soon...";
    }


    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public int getHumanStrength() {
        return humanStrength;
    }

    public void setHumanStrength(int humanStrength) {
        this.humanStrength = humanStrength;
    }

    public int getHumanStamina() {
        return humanStamina;
    }

    public void setHumanStamina(int humanStamina) {
        this.humanStamina = humanStamina;
    }

    public int getHumanHealth() {
        return humanHealth;
    }

    public void setHumanHealth(int humanHealth) {
        this.humanHealth = humanHealth;
    }

    public int getHumanLuck() {
        return humanLuck;
    }

    public void setHumanLuck(int humanLuck) {
        this.humanLuck = humanLuck;
    }
}

