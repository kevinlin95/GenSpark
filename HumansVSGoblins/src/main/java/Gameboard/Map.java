package Gameboard;

import Characters.Humans;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map {
    JPanel HumansVsGoblins;

    public Humans human = new Humans(this);
    private JTextPane Desert3;
    private JTextPane Desert2;
    private JTextPane Plains4;
    private JTextPane Swamp3;
    private JTextPane Temple;
    private JTextPane Swamp4;
    private JTextPane Castle;
    private JTextPane Plains3;
    private JTextPane Plains;
    private JTextPane Farm;
    private JTextPane Swamp2;
    private JTextPane Swamp;
    private JTextPane StartingArea;
    private JTextPane Mountains;
    private JTextPane Mountains2;
    private JTextPane Mountains3;
    private JTextPane Mountains4;
    private JTextPane Cave;
    private JTextPane Desert;
    private JButton moveDownButton;
    private JButton moveRightButton;
    private JButton moveLeftButton;
    private JButton moveUpButton;
    private JButton settingsButton;

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public Map() {
        moveUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                upPressed = true;
            }
        });
        moveLeftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                leftPressed = true;
            }
        });
        moveDownButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                downPressed = true;
            }
        });
        moveRightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                rightPressed = true;
            }
        });
    }
}
