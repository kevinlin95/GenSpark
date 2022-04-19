import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map {
    JPanel HumansVsGoblins;
    private JTextPane Desert3;
    private JTextPane Desert2;
    private JTextPane Plains4;
    private JTextPane Swamp3;
    private JTextPane Temple;
    private JTextPane Swamp4;
    private JTextPane Castle;
    private JTextPane Plains3;
    private JTextPane Plains;
    private JTextPane Plains2;
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
    private JButton Up;
    private JButton settingsButton;

    public Map() {
        Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        moveDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        moveLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        moveRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
