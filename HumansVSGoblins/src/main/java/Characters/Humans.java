package Characters;

import Gameboard.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Humans {

    Map mp;
    BufferedImage br;
    private String humanName; // name
    private int humanStrength; // damage
    private int humanStamina; // movement
    private int humanHealth; // hit points

    public Humans(Map mp) {
        this.mp = mp;
    }
    public String speak(){
        return "Begone swine!";
    }
    @Override
    public String toString(){
        return this.humanName + " has " + this.humanHealth + " HP left.";
    }

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
    public void update(){
        if(mp.upPressed == true || mp.downPressed == true
                || mp.leftPressed == true || mp.rightPressed == true){
            if(mp.upPressed == true){

            }
            else if(mp.downPressed == true){

            }
            else if(mp.leftPressed == true){

            }
            else if (mp.rightPressed == true){
       
            }
        }
    }
    public void draw(Graphics g){
        try{
            br = ImageIO.read(getClass().getResourceAsStream("/boyattack.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(br, 0, 0, 25, 25, null);
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

}

