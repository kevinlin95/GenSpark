package Characters;

import Gameboard.Map;

import java.util.List;

public class Humans extends Character {

    private String humanName; // name
    private int humanStrength; // damage
    private int humanStamina; // movement
    private int humanHealth; // hit points
    private int humanLuck; // luck for treasure chest

    public Humans(int characterPosition, Alliance characterAlliance,
                  String humanName, int humanStrength, int humanStamina,
                  int humanHealth, int humanLuck) {
        super(characterPosition, characterAlliance);
        this.humanName = humanName;
        this.humanStrength = humanStrength;
        this.humanStamina = humanStamina;
        this.humanHealth = humanHealth;
        this.humanLuck = humanLuck;
    }


    @Override
    public List<Move> calculateLegalMoves(Map map) {

        return null;
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

    @Override
    public boolean isValidPath(int finalX, int finalY) {
        return false;
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

