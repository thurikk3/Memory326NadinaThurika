package Console;

/**
 * ConsoleGame.java
 * In dieser Klasse ist die Hauptlogik implementiert.
 *
 * @author Thurika Raijkumar (thurkk3), Nadina Shirin Amlser (shirin197)
 * @version 2.0
 * @since 2022-06-14
 */

import StartUp.StartFrame;

import java.util.Scanner;

import static Console.Board.checkInput;
import static Console.Board.printBoard;
import static Console.Card.shuffleCard;


public class ConsoleGame extends StartFrame {

    /**
     * Attributes
     */
    public static Scanner sc = new Scanner(System.in);
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String[][] board = new String[6][6];
    public static String[][] cards = new String[6][6];

    public static int userPoints;
    public static int max = 5;
    public static int min = 0;
    public static int systemPoints;

    /**
     * Main Methode
     */
    public static void main(String[] args) {
        startgame();

    }

    /**
     * Methode zum Starten des Spiels
     */
    public static void startgame() {
        System.out.println(ANSI_BLUE + "============ Willkomen zum Memory Spiel! =============" + ANSI_RESET);
        System.out.println("\tWelche Version von Memory möchtest du spielen");
        System.out.println(ANSI_BLUE + "\t\t\t k " + ANSI_RESET + "= Konsolen Version");
        System.out.println(ANSI_BLUE + "\t\t\t g " + ANSI_RESET + "= GUI Version");
        System.out.println();

        System.out.println("Eingabe: ");
        String input = sc.nextLine();

        while (true) {
            if (input.equalsIgnoreCase("k")) {
                shuffleCard();
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        board[i][j] = " - ";
                    }
                }
                printBoard();
                playSystem();
                getPunkteStand();
                playAgain();
                break;

            } else if (input.equalsIgnoreCase("g")) {
                System.out.println("Das GUI Spiel wird in einem anderem Fenster geöffnet");
                StartFrame sf = new StartFrame();
                sf.setVisible(true);
                playAgain();
                break;

            } else {
                System.out.println("Bitte gib k oder g ein!");
                startgame();
            }

        }
    }

    /**
     * Methode zum Spielen des Systems
     */
    public static void playSystem() {
        System.out.println();
        System.out.println("Das System spielt ! (4sek)");
        System.out.println();
        //Thread.sleep | Unterbruch bis System 'gespielt' hat
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int durchgang = 0;
        while (true) {
            if (durchgang != 1) {
                int rowInputSystem = min + (int) (Math.random() * max);
                int columnInputSystem = min + (int) (Math.random() * max);

                if (!board[rowInputSystem][columnInputSystem].equals(" - ")) {
                    System.out.println("Schon gespielt");
                    System.out.println();
                    durchgang = 1;
                    printBoard();
                    System.out.println();
                    playSystem();
                } else {
                    board[rowInputSystem][columnInputSystem] = " " + cards[rowInputSystem][columnInputSystem] + " ";
                    printBoard();
                    System.out.println();
                }

                int row2System = min + (int) (Math.random() * max);
                int coulmn2System = min + (int) (Math.random() * max);

                if (!board[row2System][coulmn2System].equals(" - ")) {
                    System.out.println("Schon gespielt");
                    System.out.println();

                    printBoard();
                    System.out.println();

                } else {
                    board[row2System][coulmn2System] = " " + cards[row2System][coulmn2System] + " ";

                    if (board[rowInputSystem][columnInputSystem].equals(board[row2System][coulmn2System])) {
                        printBoard();
                        System.out.println();
                        systemPoints++;
                    } else {
                        printBoard();
                        System.out.println();
                        durchgang++;
                        System.out.println("Falsch. Es wurde kein Paar gefunden!");
                        board[rowInputSystem][columnInputSystem] = " - ";
                        board[row2System][coulmn2System] = " - ";
                        System.out.println("Du bist dran: ");
                        checkInput(cards);
                    }
                }
            }
        }
    }

    /**
     * Methode um das Spiel nochmals zu spielen oder beenden.
     */
    public static void playAgain() {
        System.out.println();
        System.out.println("Möchtest du das Spiel erneut starten? (j/n)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("j")) {
            startgame();
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Auf Wiedersehen!");
        } else {
            System.out.println("Bitte gib j oder n ein!");
            playAgain();
        }
    }


    /**
     * Methode ausgabe Punktestand
     */
    public static void getPunkteStand() {
        System.out.println("**********************");
        System.out.println("-----PUNKTESTAND------");
        System.out.println("-----System:" + systemPoints + "----");
        System.out.println("-----Spieler:" + userPoints + "----");
        if (systemPoints > userPoints) {
            System.out.println("Das System hat dich geschlagen");
        } else if (userPoints > systemPoints) {
            System.out.println("Du hast gewonnen");
        } else if (systemPoints == userPoints) {
            System.out.println("Gleichstand :)");
        }
        System.out.println("**********************");
    }

    /**
     * Methode GameOver
     */
    public static boolean gameOver() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j].equals(" - ")) {
                    return false;
                }
            }
        }
        return true;
    }


}
