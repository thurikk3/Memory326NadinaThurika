package Style;

import javax.swing.border.Border;
import java.awt.*;

/***
 * Buttons abrunden
 * @use ModusInput.class
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */

public class RounderBorder implements Border {

    private int radius;


    public RounderBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
