package Configuration;

/***
 * Konfigurtationen anpassen dem Modus entsprechend
 *
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */
public class Configuration {

    public static String chosen = "Images";
    public static int diff = 1;
    public static boolean smart = true;
    public static boolean bot;
    public static boolean player;


    /**
     * Konfigurationen für ein BOT Spiel
     *
     * @param value
     * @return
     */
    public boolean getConfigurationBot(String value) {
        if (value.equals("bot")) {
            return true;
        }
        return !value.equals("player");
    }

    /**
     * Konfigurationen für ein DUO Spiel
     *
     * @param value
     * @return
     */
    public boolean getConfiguratioDuo(String value) {
        if (value.equals("bot")) {
            return false;
        }
        return !value.equals("player");
    }

    /**
     * Konfigurationen für ein SOLO Spiel
     *
     * @param value
     * @return
     */
    public boolean getConfigurationSingle(String value) {
        if (value.equals("bot")) {
            return false;
        }
        return !value.equals("player");
    }
}
