import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DisplayImage extends JPanel {
    HangmanNew hangman = new HangmanNew(this);

    public DisplayImage(){
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        hangman.printHangedMan(g2);
        repaint();
    }
}