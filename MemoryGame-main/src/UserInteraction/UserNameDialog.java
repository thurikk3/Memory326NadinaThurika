package UserInteraction;

import javax.swing.*;


/***
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */
public class UserNameDialog {

    /**
     * Eingabe Name des 2.Spielers
     * Username
     *
     * @return name
     */
    public String getNamePlayer() {
        String name = JOptionPane.showInputDialog("Wie heisst der 2.Spieler");
        System.out.println(name);
        return name;
    }
}
