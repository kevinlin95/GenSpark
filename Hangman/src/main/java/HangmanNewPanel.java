import javax.swing.*;
import java.awt.Graphics;
import java.util.Objects;

public class HangmanNewPanel extends JPanel {

    public HangmanNewPanel(){

    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        ImageIcon icon = new ImageIcon
                (Objects.requireNonNull(HangmanNewPanel.class.getResource
                        ("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmandefault.webp")));
        icon.paintIcon(this, g, 100, 100);
    }
}

