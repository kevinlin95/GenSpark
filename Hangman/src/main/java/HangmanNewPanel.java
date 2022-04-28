import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HangmanNewPanel extends Canvas {

    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmandefault.webp");
        g.drawImage(i, 100, 100, this);
    }
    public static void main(String[] args) {
        HangmanNewPanel m = new HangmanNewPanel();
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(800,800);
        f.setVisible(true);
    }


}

