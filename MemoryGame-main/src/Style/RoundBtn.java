package Style;

import javax.swing.border.Border;
import java.awt.*;

/***
 * Buttons in Kreis Form erstellen
 * @use ModusInput.class
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */

public class RoundBtn implements Border {

    private int r;

    public RoundBtn(int r) {
        this.r = r;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, r, r);
    }
}
