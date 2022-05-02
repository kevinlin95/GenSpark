import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        HangmanNew hangman = new HangmanNew();
        DisplayImage image = new DisplayImage();
        JFrame frame = new JFrame("HangMan");
        frame.add(image);
        frame.pack();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        hangman.gameMode();
    }
}
