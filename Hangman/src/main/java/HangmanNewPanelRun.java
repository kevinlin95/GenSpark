import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HangmanNewPanelRun extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater((() -> {
            try {
                HangmanNewPanelRun frame = new HangmanNewPanelRun();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
    public HangmanNewPanelRun(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 1000);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5,5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        HangmanNewPanel hangmanPanel = new HangmanNewPanel();
        contentPane.add(hangmanPanel, BorderLayout.CENTER);
    }
}
