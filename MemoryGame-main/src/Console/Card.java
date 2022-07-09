package Console;


/**
 * Card.java
 * Diese Klasse wird verwendet um die Karten zu erstellen.
 *
 * @author Thurika Raijkumar (thurkk3), Nadina Shirin Amlser (shirin197)
 * @version 2.0
 * @since 2022-06-14
 */

import java.util.ArrayList;
import java.util.Random;

public class Card extends ConsoleGame {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Vermischt die Karten.
     */
    public static void shuffleCard() {
        Random r = new Random();
        ArrayList<String> symbols = new ArrayList<>();

        //Füllt die ArrayList mit Symbolen
        symbols.add(ANSI_BLUE + "♡" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♥" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☻" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "❉" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☼" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☯" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♕" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "✻" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "✿" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "★" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☆" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "❁" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "❀" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "⚝" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♋" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♌" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♬" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "ꐕ" + ANSI_RESET);

        symbols.add(ANSI_BLUE + "♡" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♥" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☻" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "❉" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☼" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☯" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♕" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "✻" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "✿" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "★" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "☆" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "❁" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "❀" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "⚝" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♋" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♌" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "♬" + ANSI_RESET);
        symbols.add(ANSI_BLUE + "ꐕ" + ANSI_RESET);

        int index;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                index = r.nextInt(symbols.size());
                cards[i][j] = symbols.get(index);
                symbols.remove(index);
            }
        }
    }
}
