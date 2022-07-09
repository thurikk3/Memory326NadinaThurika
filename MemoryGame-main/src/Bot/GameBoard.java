package Bot;

import Configuration.Configuration;
import EndPages.Looser;
import EndPages.Tie;
import EndPages.Winner;
import StartUp.ModusInput;
import Style.RounderBorder;
import UserInteraction.SimpleInputDialog;
import images.MemoryPictures;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

/***
 * GUI Logik für das Board
 * Version gegen das System
 *
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */
public class GameBoard extends JFrame implements ActionListener {

    public static ArrayList<JButton> cardButton = new ArrayList<JButton>();
    public static ArrayList<Integer> integers = new ArrayList<Integer>();
    private int temp, temp2, score1 = 0, score2 = 0;
    public static int counter = 0;
    private boolean player1 = true, player2 = false;
    private final JButton neustart;
    private final JButton zurückBtn;
    private final JEditorPane playername1;
    private final JEditorPane playername2;
    private final JLabel playerscore1;
    private final JLabel playerscore2;
    private final JLabel mark;
    private Timer tw = new Timer();
    private MemoryBot memoryBot;
    private final int levelDifficult = 1;
    private final boolean smart = true;

    Configuration c = new Configuration();

    private final Icon ruckseite;
    private final Icon memory1;
    private final Icon memory2;
    private final Icon memory3;
    private final Icon memory4;
    private final Icon memory5;
    private final Icon memory6;
    private final Icon memory7;
    private final Icon memory8;


    /**
     * Verschiedene Fonts
     */
    private Font h1Font = new Font("Arial", Font.BOLD, 40);
    private Font h2Font = new Font("Arial", Font.BOLD, 17);
    private Font h3Font = new Font("Arial", Font.PLAIN, 19);
    private Font h4Font = new Font("Arial", Font.ITALIC, 17);

    private Color darkblue = new Color(38, 85, 132);
    private Color lightblue = new Color(218, 240, 247);

    /**
     * GameBord aufsetzten
     *
     * @param title
     */
    public GameBoard(String title) {

        new MemoryPictures();

        /**
         * Festlegung Bilder für die Karten
         */
        ruckseite = new ImageIcon(MemoryPictures.getImgURLr());
        memory1 = new ImageIcon(MemoryPictures.getImgURL1());
        memory2 = new ImageIcon(MemoryPictures.getImgURL2());
        memory3 = new ImageIcon(MemoryPictures.getImgURL3());
        memory4 = new ImageIcon(MemoryPictures.getImgURL4());
        memory5 = new ImageIcon(MemoryPictures.getImgURL5());
        memory6 = new ImageIcon(MemoryPictures.getImgURL6());
        memory7 = new ImageIcon(MemoryPictures.getImgURL7());
        memory8 = new ImageIcon(MemoryPictures.getImgURL8());

        /**
         * Frame aufsetzten
         */
        setTitle(title);
        setSize(1200, 900);
        setLayout(null);
        setBackground(lightblue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        neustart = new JButton("Neustarten");
        neustart.setBounds(920, 300, 200, 50);
        neustart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameBoard b = new GameBoard("Game gegen das System");
                setVisible(false);
                dispose();
            }
        });
        neustart.setPreferredSize(new Dimension(200, 50));
        neustart.setBorder(new RounderBorder(8));
        neustart.setBackground(darkblue);
        neustart.setFont(h3Font);
        neustart.setForeground(Color.WHITE);
        add(neustart);

        zurückBtn = new JButton("Zurück");
        zurückBtn.setBounds(920, 400, 200, 50);
        zurückBtn.setPreferredSize(new Dimension(200, 50));
        zurückBtn.setBorder(new RounderBorder(8));
        zurückBtn.setBackground(darkblue);
        zurückBtn.setFont(h3Font);
        zurückBtn.setForeground(Color.WHITE);
        zurückBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModusInput mi = new ModusInput();
                setVisible(false);
                dispose();
            }
        });
        add(zurückBtn);

        playername1 = new JEditorPane();
        playername1.setBounds(920, 150, 150, 30);
        SimpleInputDialog sd = new SimpleInputDialog();
        playername1.setText(sd.getNamePlayer());
        playername1.setEditable(false);
        playername1.setFont(h2Font);
        playername1.setForeground(darkblue);
        add(playername1);

        playername2 = new JEditorPane();
        playername2.setBounds(920, 190, 150, 30);
        playername2.setText("Computer");
        playername2.setFont(h2Font);
        playername2.setForeground(darkblue);
        playername2.setEditable(false);
        add(playername2);

        playerscore1 = new JLabel();
        playerscore1.setBounds(1080, 150, 30, 20);
        playerscore1.setText("" + 0);
        playerscore1.setFont(h2Font);
        playerscore1.setForeground(darkblue);
        add(playerscore1);

        playerscore2 = new JLabel();
        playerscore2.setBounds(1080, 190, 30, 20);
        playerscore2.setText("" + 0);
        playerscore2.setFont(h2Font);
        playerscore2.setForeground(darkblue);
        add(playerscore2);

        mark = new JLabel("☞");
        mark.setBounds(900, 150, 20, 20);
        add(mark);

        new Randomizer(integers);

        /**
         * Board erstellen
         */
        for (int i = 0; i < 16; i++) {

            cardButton.add(new JButton(ruckseite));

            if (i <= 3) {
                cardButton.get(i).setBounds(20 + i * 220, 0, 200, 200);
            } else if (i <= 7) {
                cardButton.get(i).setBounds(20 + (i - 4) * 220, 220, 200, 200);
            } else if (i <= 11) {
                cardButton.get(i).setBounds(20 + (i - 8) * 220, 440, 200, 200);
            } else if (i <= 15) {
                cardButton.get(i).setBounds(20 + (i - 12) * 220, 660, 200, 200);
            }

            cardButton.get(i).addActionListener(this);

            add(cardButton.get(i));
        }

        getContentPane().setBackground(lightblue);
        setBackground(lightblue);
        setVisible(true);


        if (c.getConfigurationBot("bot")) {
            memoryBot = new MemoryBot(levelDifficult, cardButton, smart);

            if (c.getConfigurationBot("player")) {
                memoryBot.play();
            }
        }

    }

    /**
     * Actions den Buttons hinzufügen
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == neustart) {

            if (c.getConfigurationBot("bot")) {
                memoryBot.delete();
                memoryBot = new MemoryBot(levelDifficult, cardButton, smart);

                if (c.getConfigurationBot("player")) {
                    memoryBot.play();
                }
            }
            tw.cancel();
            tw = new Timer();
            new Randomizer(integers);
            for (int i = 0; i < integers.size(); i++) {
                cardButton.get(i).setIcon(ruckseite);
                cardButton.get(i).setEnabled(true);
            }
            counter = 0;

            player1 = true;
            player2 = false;

            mark.setBounds(900, 150, 20, 20);

            score1 = 0;
            score2 = 0;
            playerscore1.setText("" + score1);
            playerscore2.setText("" + score2);
            setVisible(true);

        } else {
            for (int i = 0; i < integers.size(); i++) {
                if (e.getSource() == cardButton.get(i)) {

                    if (counter == 0) {

                        counter = 1;
                        temp = integers.get(i);
                        temp2 = i;
                        if (integers.get(i) == 0) {
                            cardButton.get(i).setIcon(memory1);
                        } else if (integers.get(i) == 1) {
                            cardButton.get(i).setIcon(memory2);
                        } else if (integers.get(i) == 2) {
                            cardButton.get(i).setIcon(memory3);
                        } else if (integers.get(i) == 3) {
                            cardButton.get(i).setIcon(memory4);
                        } else if (integers.get(i) == 4) {
                            cardButton.get(i).setIcon(memory5);
                        } else if (integers.get(i) == 5) {
                            cardButton.get(i).setIcon(memory6);
                        } else if (integers.get(i) == 6) {
                            cardButton.get(i).setIcon(memory7);
                        } else if (integers.get(i) == 7) {
                            cardButton.get(i).setIcon(memory8);
                        } else if (integers.get(i) == 50) {
                            counter = 0;
                        }

                        if (c.getConfigurationBot("bot")) {
                            if (levelDifficult == 1) {
                                if (isBot()) {
                                    memoryBot.setNumber(i, integers.get(i));
                                }
                            } else if (levelDifficult >= 2) {
                                memoryBot.setNumber(i, integers.get(i));
                            }
                        }

                    } else if (counter == 1) {

                        counter = 2;

                        if (integers.get(i) == 0) {
                            cardButton.get(i).setIcon(memory1);
                        } else if (integers.get(i) == 1) {
                            cardButton.get(i).setIcon(memory2);
                        } else if (integers.get(i) == 2) {
                            cardButton.get(i).setIcon(memory3);
                        } else if (integers.get(i) == 3) {
                            cardButton.get(i).setIcon(memory4);
                        } else if (integers.get(i) == 4) {
                            cardButton.get(i).setIcon(memory5);
                        } else if (integers.get(i) == 5) {
                            cardButton.get(i).setIcon(memory6);
                        } else if (integers.get(i) == 6) {
                            cardButton.get(i).setIcon(memory7);
                        } else if (integers.get(i) == 7) {
                            cardButton.get(i).setIcon(memory8);
                        } else if (integers.get(i) == 50) {
                            counter = 1;
                        }

                        if (c.getConfigurationBot("bot")) {
                            if (levelDifficult == 1) {
                                if (isBot()) {
                                    memoryBot.setNumber(i, integers.get(i));
                                }
                            } else if (levelDifficult >= 2) {
                                memoryBot.setNumber(i, integers.get(i));
                            }
                        }

                        if (temp == integers.get(i)) {
                            if (!(temp2 == i)) {
                                if (!(integers.get(i) == 50)) {
                                    integers.set(i, 50);
                                    integers.set(temp2, 50);
                                    if (player1) {
                                        counter = 0;
                                        score1++;
                                        playerscore1.setText("" + score1);
                                        setVisible(true);

                                        if (c.getConfigurationBot("bot")) {
                                            memoryBot.revealCard(cardButton.get(i));
                                            memoryBot.revealCard(cardButton.get(temp2));

                                            if (isBot()) {
                                                if (score1 + score2 != 8) {
                                                    if (MemoryBot.Winner1) {
                                                        MemoryBot.Winner2 = true;
                                                    }
                                                    MemoryBot.Winner1 = true;
                                                    memoryBot.play();
                                                }
                                            }
                                        }
                                    }
                                    if (player2) {
                                        counter = 0;
                                        score2++;
                                        playerscore2.setText("" + score2);
                                        setVisible(true);

                                        if (c.getConfigurationBot("bot")) {
                                            memoryBot.revealCard(cardButton.get(i));
                                            memoryBot.revealCard(cardButton.get(temp2));

                                            memoryBot.setNumber(i, 50);
                                            memoryBot.setNumber(temp2, 50);

                                            if (isBot()) {
                                                if (score1 + score2 != 8) {
                                                    if (MemoryBot.Winner1) {
                                                        MemoryBot.Winner2 = true;
                                                    }
                                                    MemoryBot.Winner1 = true;
                                                    memoryBot.play();
                                                }
                                            }
                                        }
                                    }
                                    /**
                                     * Auswertung wer gewonnen hat und wer verloren hat
                                     */
                                    if (score1 + score2 == 8) {
                                        for (JButton jButton : cardButton) {
                                            jButton.setEnabled(true);
                                        }

                                        if (score1 < score2) {
                                            Looser l = new Looser(playername1.getText());
                                            setVisible(false);
                                            dispose();
                                        } else if (score2 < score1) {
                                            Winner w = new Winner(playername1.getText());
                                            setVisible(false);
                                            dispose();
                                        } else if (score1 == score2) {
                                            Tie t = new Tie();
                                            setVisible(false);
                                            dispose();

                                        }
                                    }
                                }
                            } else
                                counter = 1;
                        } else {

                            TimerTask tt = new TimerTask() {

                                @Override
                                public void run() {
                                    for (JButton b : cardButton) {
                                        b.setEnabled(true);
                                    }
                                    counter = 0;
                                    for (int i = 0; i < integers.size(); i++) {
                                        if (!(integers.get(i) == 50)) {
                                            cardButton.get(i).setIcon(ruckseite);
                                        }
                                    }
                                    if (player1) {
                                        player1 = false;
                                        player2 = true;

                                        mark.setBounds(900, 190, 20, 20);
                                        setVisible(true);

                                        if (c.getConfigurationBot("bot")) {
                                            if (!c.getConfigurationBot("player")) {
                                                memoryBot.play();
                                            }
                                        }

                                    } else if (player2) {
                                        player1 = true;
                                        player2 = false;

                                        mark.setBounds(900, 150, 20, 20);
                                        setVisible(true);

                                        if (c.getConfigurationBot("bot")) {
                                            if (c.getConfigurationBot("player")) {
                                                memoryBot.play();
                                            }
                                        }

                                    }

                                }
                            };
                            if (integers.get(i) == 50) {
                                counter = 1;
                            } else {
                                tw.schedule(tt, 1500);
                            }
                        }

                    }

                }

            }
        }

    }

    /**
     * Nachfrage ob es ein Spiel gegen dem Bot ist
     *
     * @return
     */
    public boolean isBot() {
        if (player1 && c.getConfigurationBot("player")) {
            return true;
        } else if (player2 && !c.getConfigurationBot("player")) {
            return true;
        } else
            return false;

    }
}