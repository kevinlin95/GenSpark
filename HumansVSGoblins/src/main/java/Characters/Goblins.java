package Characters;

public class Goblins extends Character {

    private int goblinStrength = 0; //damage
    private int goblinStamina = 0; // movement
    private int goblinHealth = 0; // hit points

    @Override
    public String speak(){
        return "Human bad! Die! ";
    }

    @Override
    public String attack(Object other) {
        return null;
    }

    public int getGoblinStrength() {
        return goblinStrength;
    }

    public void setGoblinStrength(int goblinStrength) {
        this.goblinStrength = goblinStrength;
    }

    public int getGoblinStamina() {
        return goblinStamina;
    }

    public void setGoblinStamina(int goblinStamina) {
        this.goblinStamina = goblinStamina;
    }

    public int getGoblinHealth() {
        return goblinHealth;
    }

    public void setGoblinHealth(int goblinHealth) {
        this.goblinHealth = goblinHealth;
    }
}
