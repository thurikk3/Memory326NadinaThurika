package StartUp;

import Style.RounderBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * StartFrame welches den Startbutton zum starten des Spieles hat.
 *
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */


/**
 * Die Hauptseite um die GUI-Version des Spieles zu starten
 * @author thurika, shirin
 * @since 25.06.2022
 *
 */
public class StartFrame extends JFrame {
    private JPanel titelPanel = new JPanel(new BorderLayout(100, 100));
    private JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

    private JButton startButton;
    private JLabel titel = new JLabel("Herzlich Wilkommen zum Memory");
    private JLabel fillerButton = new JLabel("");
    ;
    private JLabel fillerButton2 = new JLabel("");
    ;

    private Color lightblue = new Color(218, 240, 247);
    private Font h1Font = new Font("Arial", Font.BOLD, 45);
    private Font h2Font = new Font("Arial", Font.PLAIN, 21);
    private Color darkblue = new Color(38, 85, 132);


    public StartFrame() {
        /**
         * Frame setzten
         */
        setTitle("Start Game");
        setLayout(new BorderLayout());
        setSize(900, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.RED);

        /**
         * Begrüssungs Text zentriert setzten
         */
        titel.setFont(h1Font);
        titel.setForeground(darkblue);
        titel.setHorizontalAlignment(JLabel.CENTER);
        titel.setVerticalAlignment(JLabel.CENTER);

        /**
         * Start Button um das Spiel zu starten
         */
        startButton = new JButton("Starten");
        startButton.setBackground(darkblue);
        startButton.setFont(h2Font);
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(150, 45));
        startButton.setBorder(new RounderBorder(20));
        startButton.setFocusPainted(false);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModusInput();
                dispose();
            }
        });

        titelPanel.add(titel);

        buttonPanel.add(fillerButton);
        buttonPanel.add(startButton);
        buttonPanel.add(fillerButton2);

        buttonPanel.setBackground(lightblue);
        titelPanel.setBackground(lightblue);

        /**
         * Panels ausrichten
         */
        getContentPane().add(titelPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

}
