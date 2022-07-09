package Bot;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

/***
 * Bot Logik für das Memory
 * Random Karten auswählen
 *
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */
public class MemoryBot {

    private int difficulty;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<JButton> buttons;
    public static ArrayList<JButton> cardTurned = new ArrayList<>(), cardFree = new ArrayList<>();
    private static JButton clicked = null;
    private static int tempValue = -1;
    public static boolean Winner1 = false;
    public static boolean Winner2 = false;
    private boolean smort = false;

    /**
     * Kontruktor für den Bot
     *
     * @param difficulty
     * @param buttons
     * @param smart
     */
    public MemoryBot(int difficulty, ArrayList<JButton> buttons, boolean smart) {
        this.difficulty = difficulty;
        this.buttons = buttons;
        this.smort = smart;

        cardFree.addAll(buttons);

        for (int i = 0; i < 16; i++) {
            numbers.add(-1);
        }
    }


    /**
     * den Bot spielen lassen
     */
    public void play() {

        if (GameBoard.counter == 0) {
            for (JButton b : buttons) {
                b.setEnabled(false);
            }
            TurnOne1();
        } else if (GameBoard.counter == 1) {
            TurnTwo2();
        }
    }

    /**
     * Die Nummer für die Position der Kartenauswahl setzten
     *
     * @param position
     * @param number
     */
    public void setNumber(int position, int number) {
        numbers.set(position, number);
    }


    /**
     * Die Karten umdrehen
     */
    public void TurnOne() {
        int rnd = (int) (Math.random() * cardFree.size());

        JButton b = cardFree.get(rnd);


        if (!cardTurned.contains(b)) {
            b.setEnabled(true);
            b.doClick();
            clicked = b;
            if (smort) {
                tempValue = numbers.get(buttons.indexOf(b));
            }
        }
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                play();
            }
        };
        t.schedule(tt, 1500);

    }

    /**
     * Die Karte umdrehen
     */
    public void TurnOne1() {

        boolean b = false;
        int number = -1;
        tempValue = -1;

        for (int i : numbers) {
            if (i != -1 && i != 50) {
                if (numbers.indexOf(i) != numbers.lastIndexOf(i)) {
                    b = true;
                    number = i;
                }
            }
        }
        if (b) {

            JButton bt = buttons.get(numbers.indexOf(number));
            tempValue = number;
            bt.setEnabled(true);
            bt.doClick();

            clicked = bt;

            Timer t = new Timer();
            TimerTask tt = new TimerTask() {

                @Override
                public void run() {
                    play();
                }
            };
            t.schedule(tt, 1500);

        } else {
            TurnOne();
        }

    }

    /**
     * Die Karte umdrehen
     */
    public void TurnTwo() {
        int rnd = (int) (Math.random() * cardFree.size());

        JButton b = cardFree.get(rnd);

        if (cardFree.size() == 1) {
            cardFree.get(0).setEnabled(true);
            cardFree.get(0).doClick();
        }

        if (!cardTurned.contains(b)) {
            if (b != clicked) {
                b.setEnabled(true);
                b.doClick();
            } else
                TurnTwo();
        } else
            TurnTwo();
    }

    /**
     * Karte umdrehen
     */
    public void TurnTwo2() {

        if (tempValue != -1) {
            if (numbers.lastIndexOf(tempValue) != -1 && !cardTurned.contains(buttons.get(numbers.lastIndexOf(tempValue)))
                    && numbers.indexOf(tempValue) != numbers.lastIndexOf(tempValue)) {
                JButton b2 = buttons.get(numbers.lastIndexOf(tempValue));
                JButton b1 = buttons.get(numbers.indexOf(tempValue));
                JButton b = null;
                if (b1 != clicked) {
                    b = b1;
                } else if (b2 != clicked) {
                    b = b2;
                }

                if (b != clicked) {
                    b.setEnabled(true);
                    b.doClick();

                    if (numbers.contains(tempValue)) {
                        numbers.set(numbers.indexOf(tempValue), -1);
                        if (numbers.contains(tempValue)) {
                            numbers.set(numbers.lastIndexOf(tempValue), -1);
                        }
                    }

                    tempValue = -1;
                    clicked = null;
                }
            } else {
                TurnTwo();
            }

        } else {
            TurnTwo();
        }

    }

    /**
     * Karte umdrehen und aus der Auswahl löschen
     *
     * @param card
     */
    public void revealCard(JButton card) {
        cardFree.remove(card);
        cardTurned.add(card);
    }

    /**
     * Karte löschen
     */
    public void delete() {
        numbers.clear();
        difficulty = 0;
        cardTurned.clear();
        cardFree.clear();
        clicked = null;
        buttons = null;
    }

}
