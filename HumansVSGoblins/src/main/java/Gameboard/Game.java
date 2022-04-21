package Gameboard;

import javax.swing.*;

public class Game extends Map {
    public static void main(String[] args){
        JFrame HumansVsGoblins = new JFrame("Map");
        HumansVsGoblins.setContentPane(new Map().HumansVsGoblins);
        HumansVsGoblins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HumansVsGoblins.pack();
        HumansVsGoblins.setVisible(true);
    }
}
