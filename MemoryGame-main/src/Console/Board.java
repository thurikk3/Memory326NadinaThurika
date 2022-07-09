package Console;

import java.util.Scanner;

/**
 * Board.java
 * Diese Klasse wird verwendet um das Spielfeld zu erstellen.
 *
 * @author Thurika Raijkumar (thurkk3), Nadina Shirin Amlser (shirin197)
 * @version 2.0
 * @since 2022-06-12
 */


public class Board extends ConsoleGame {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Methode ausgabe Spielfeld
     */
    public static void printBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 6; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * Diese Methode wird verwendet um die Eingabe des Spielers zu verarbeiten.
     *
     * @param cards
     */
    public static void checkInput(String[][] cards) {
        while (true) {
            if (!gameOver()) {
                System.out.println("Reihe: (1-6)");
                int row1 = getRowInput(sc.next());
                System.out.println("Spalte: (1-6)");
                int coulmn1 = getColumnInput(sc.next());
                if (!board[row1 - 1][coulmn1 - 1].equals(" - ")) {
                    System.out.println("Schon gespielt");
                    System.out.println();

                    printBoard();
                    System.out.println();
                } else {
                    board[row1 - 1][coulmn1 - 1] = " " + cards[row1 - 1][coulmn1 - 1] + " ";
                    printBoard();
                    System.out.println();
                }
                System.out.println("Reihe: (1-6)");
                int row2 = getRowInput(sc.next());
                System.out.println("Spalte: (1-6)");
                int coulmn2 = getColumnInput(sc.next());

                if (!board[row2 - 1][coulmn2 - 1].equals(" - ")) {
                    System.out.println("Schon gespielt");
                    System.out.println();

                    printBoard();
                    System.out.println();
                } else {
                    board[row2 - 1][coulmn2 - 1] = " " + cards[row2 - 1][coulmn2 - 1] + " ";

                    // Wenn die Karten gleich sind, wird das Spielfeld aktualisiert.
                    if (board[row1 - 1][coulmn1 - 1].equals(board[row2 - 1][coulmn2 - 1])) {
                        printBoard();
                        System.out.println();
                        System.out.println("Richtig! Du bist nochmals dran.");
                        userPoints++;
                    } else {
                        // Wenn die Karten nicht gleich sind, wird das Spielfeld aktualisiert.
                        printBoard();
                        System.out.println();
                        System.out.println("Falsch. Kein Paar gefunden!");
                        System.out.println();
                        board[row1 - 1][coulmn1 - 1] = " - ";
                        board[row2 - 1][coulmn2 - 1] = " - ";
                        printBoard();
                        playSystem();
                    }
                }

            } else {
                System.out.println("GameOver!"); // Spiel ist beendet.

            }

        }
    }


    /**
     * Eingabe für die Spalte, wenn der Spieler am Zug ist.
     * Wenn diese Falsch ist, wird gefragt, nochmal zu einzugeben.
     *
     * @return the column
     * @return getColumnInput()
     */
    public static int getColumnInput(String value) throws NumberFormatException {
        int column = Integer.parseInt(value);
        if (column > 6|| column < 1||!sc.hasNextInt()) {
            System.err.println("wrong input");
            System.out.println("gebe erneuert ein: ");
            return getColumnInput(String.valueOf(sc.nextInt()));
        }else if(!sc.hasNextInt()){
            System.out.println("SAD");
        }
        return column;
    }

    /**
     * Eingabe für die Reihe, wenn der Spieler am Zug ist.
     * Wenn diese Falsch ist, wird gefragt, nochmal zu einzugeben.
     *
     * @return the row
     * @return getRowInput()
     */
    public static int getRowInput(String value) {
        int row = Integer.parseInt(value);
        if (row > 6|| row < 1||!sc.hasNextInt()) {
            System.err.println("wrong input");
            System.out.println("gebe erneuert ein: ");
            return getRowInput(String.valueOf(sc.nextInt()));
        }
        return row;
    }

}
