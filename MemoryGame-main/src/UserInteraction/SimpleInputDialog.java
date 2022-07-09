package UserInteraction;


import javax.swing.*;

/***
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */

public class SimpleInputDialog {

    /**
     * Eingabe Name des Spielers
     *
     * @return name
     */
    public String getNamePlayer() {
        String name = JOptionPane.showInputDialog("Wie heisst du?");
        System.out.println(name);
        return name;
    }
}