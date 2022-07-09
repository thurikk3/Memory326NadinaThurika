package StartUp;

import Bot.GameBoard;
import Duo.GameBoardDuo;
import Solo.GameBoardSolo;
import Style.RoundBtn;
import Style.RoundedButton;
import Style.RounderBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Die Zweite Seite nach der Startseite
 * Hier wird der User nach dem Spielmodus abgefraget
 * - Single
 * - Duo
 * - Bot
 *
 * @author thurika, shirin
 * @since 22.06.2022
 */
public class ModusInput extends JFrame {
    /**
     * JPanels erstellen
     */
    private JPanel titelPanel = new JPanel(new BorderLayout(150, 150));
    private JPanel ModusPanel = new JPanel(new GridLayout(1, 3, 40, 40));
    private JPanel Filler = new JPanel(new BorderLayout());
    private JPanel contentPanel = new JPanel(new BorderLayout());
    private JPanel footerPanel = new JPanel(new BorderLayout(20, 150));
    private JPanel buttonPanel = new JPanel(new BorderLayout(20, 20));
    private JPanel autorPanel = new JPanel(new BorderLayout(20, 20));

    private JLabel titel = new JLabel(" Wähle einen Spielmodus aus");
    private JLabel autor = new JLabel(" © Nadina Amsler & Thurika Rajkumar ");


    /**
     * Verschiedene Fonts
     */
    private Font h1Font = new Font("Arial", Font.BOLD, 40);
    private Font h2Font = new Font("Arial", Font.BOLD, 25);
    private Font h3Font = new Font("Arial", Font.PLAIN, 19);
    private Font h4Font = new Font("Arial", Font.ITALIC, 17);

    /**
     * Die nötigen Farben
     */
    private Color lightblue = new Color(218, 240, 247);
    private Color darkblue = new Color(38, 85, 132);


    private JButton duoModus = new RoundedButton("Duo");
    private JButton systemPlay = new RoundedButton("Bot");
    private JButton singleModus = new RoundedButton("Single");
    private JButton backButton = new JButton("zurück");


    public ModusInput() {
        /**
         * Frame setzten
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Spielmodus");
        setResizable(false);
        setSize(900, 900);
        setLayout(new GridLayout(4, 1));

        /**
         * Begrüssungs Text zentriert setzten
         */
        titel.setFont(h1Font);
        titel.setForeground(darkblue);
        titel.setHorizontalAlignment(JLabel.CENTER);
        titel.setVerticalAlignment(JLabel.CENTER);
        titelPanel.add(titel);


        /**
         * Die drei Modus Buttons stylens
         */
        duoModus.setBorder(new RoundBtn(15));
        duoModus.setBackground(darkblue);
        duoModus.setFont(h2Font);
        duoModus.setForeground(Color.WHITE);


        systemPlay.setBounds(70, 80, 280, 100);
        systemPlay.setBorder(new RoundBtn(5));
        systemPlay.setBackground(darkblue);
        systemPlay.setFont(h2Font);
        systemPlay.setForeground(Color.WHITE);


        /**
         * Zurück Knopf um auf der Start seite zu gelangen
         */
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.setBorder(new RounderBorder(8));
        backButton.setBackground(darkblue);
        backButton.setFont(h3Font);
        backButton.setForeground(Color.WHITE);


        contentPanel.add(ModusPanel, BorderLayout.CENTER);
        contentPanel.setBackground(lightblue);
        ModusPanel.add(singleModus);
        ModusPanel.add(duoModus, new BorderLayout(10, 10));
        ModusPanel.add(systemPlay, new BorderLayout(10, 10));
        singleModus.setBounds(70, 80, 280, 100);
        singleModus.setBorder(new RoundBtn(15));
        singleModus.setBackground(darkblue);
        singleModus.setFont(h2Font);
        singleModus.setForeground(Color.WHITE);


        /**
         * Actions den Buttons hinzufügen
         */
        singleModus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameBoardSolo gbs = new GameBoardSolo();
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartFrame st = new StartFrame();
            }
        });
        systemPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameBoard gameBoard = new GameBoard("Spiel gegen BOT");
                dispose();
            }
        });
        duoModus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameBoardDuo dm = new GameBoardDuo();
            }
        });


        autor.setFont(h4Font);
        autor.setForeground(darkblue);

        autorPanel.add(autor, BorderLayout.SOUTH);
        buttonPanel.add(backButton, BorderLayout.SOUTH);

        footerPanel.add(buttonPanel, BorderLayout.WEST);
        footerPanel.add(autorPanel, BorderLayout.EAST);

        /**
         * Hintergrund Farbe anpassen
         */
        titelPanel.setBackground(lightblue);
        buttonPanel.setBackground(lightblue);
        autorPanel.setBackground(lightblue);
        Filler.setBackground(lightblue);
        ModusPanel.setBackground(lightblue);
        footerPanel.setBackground(lightblue);

        getContentPane().add(titelPanel, BorderLayout.NORTH);
        getContentPane().add(Filler);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        getContentPane().add(Filler);
        getContentPane().add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ModusInput();
    }

}