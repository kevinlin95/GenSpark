import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayImage {

    public static void printHangedMan(int incorrectCount) throws IOException {
        File file = switch (incorrectCount) {
            case 1 -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmanhead1.png");
            case 2 -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmanbody2.png");
            case 3 -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmanrightarm3.png");
            case 4 -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmanleftarm4.png");
            case 5 -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmanrightleg5.png");
            case 6 -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmanleftleg6.png");
            default -> new File("/Users/kevinsmacbookair/GenSpark/Hangman/src/main/resources/hangmandefault.png");
        };
        BufferedImage bufferedImage = ImageIO.read(file);

        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new FlowLayout());

        jFrame.setSize(820, 820);
        JLabel jLabel = new JLabel();

        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}