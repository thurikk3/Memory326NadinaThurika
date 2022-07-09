package EndPages;

import StartUp.StartFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * JFrame wenn der Spieler gewonnen hat
 *
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */
public class Winner extends JFrame {

    private Color lightblue = new Color(218, 240, 247);
    private JLabel titel;
    private JPanel textPanel = new JPanel(new BorderLayout());
    private JPanel buttonPanel = new JPanel(new BorderLayout());
    private JButton back = new JButton("Zurück");
    private JButton end = new JButton("Beenden");
    private JPanel panel = new JPanel(new BorderLayout());
    private Font h1Font = new Font("Arial", Font.BOLD, 30);
    private Color darkblue = new Color(38, 85, 132);
    private Font h2Font = new Font("Arial", Font.PLAIN, 18);

    public Winner(String name) {

        /**
         * Frame aufsetzten
         */
        setTitle("GameOver");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);
        setSize(800, 700);
        setLayout(new BorderLayout());


        titel = new JLabel(name + " hat das Spiel gewonnen :)");
        titel.setFont(h1Font);
        titel.setForeground(darkblue);
        titel.setHorizontalAlignment(JLabel.CENTER);
        titel.setVerticalAlignment(JLabel.CENTER);
        textPanel.setBackground(lightblue);

        buttonPanel.add(end, BorderLayout.EAST);
        end.setBounds(0, 0, 3470, 50);
        end.setBackground(darkblue);
        end.setFocusable(false);
        end.setFont(h2Font);
        end.setForeground(Color.WHITE);
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        buttonPanel.add(back, BorderLayout.WEST);
        back.setBounds(0, 0, 3470, 50);
        back.setBackground(darkblue);
        back.setFocusable(false);
        back.setFont(h2Font);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartFrame m = new StartFrame();
                setVisible(false);
                dispose();
            }
        });

        textPanel.add(titel, BorderLayout.CENTER);
        panel.add(textPanel, BorderLayout.CENTER);
        buttonPanel.setBackground(lightblue);
        setBackground(lightblue);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

}
