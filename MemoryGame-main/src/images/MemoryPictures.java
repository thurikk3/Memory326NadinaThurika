package images;

import java.net.URL;

/***
 * Bilder in einer sepraten Klasse konfigurieren
 * - Jederzeit anpassen
 * @author Thurika Rajkumar, Nadina Shirin Amlser (shirin197)
 * @version 3.0
 * @since 2022-07-06
 */

public class MemoryPictures {

    public static URL imgURLr, imgURL1, imgURL2, imgURL3, imgURL4, imgURL5, imgURL6, imgURL7, imgURL8;

    /**
     * Die Bilder konfigurieren
     */
    public MemoryPictures() {


        imgURLr = getClass().getResource("/images/memoryBackseite.jpg");
        imgURL1 = getClass().getResource("/images/drake.jpg");
        imgURL2 = getClass().getResource("/images/JackHarrlow.jpg");
        imgURL3 = getClass().getResource("/images/lana.jpg");
        imgURL4 = getClass().getResource("/images/theWeeknd.jpg");
        imgURL5 = getClass().getResource("/images/xxxtentacion.jpg");
        imgURL6 = getClass().getResource("/images/michaelJackson.jpg");
        imgURL7 = getClass().getResource("/images/arianaGrande.jpg");
        imgURL8 = getClass().getResource("/images/chrisbrown.jpg");


    }

    public static URL getImgURLr() {
        return imgURLr;
    }

    public static URL getImgURL1() {
        return imgURL1;
    }

    public static URL getImgURL2() {
        return imgURL2;
    }

    public static URL getImgURL3() {
        return imgURL3;
    }

    public static URL getImgURL4() {
        return imgURL4;
    }

    public static URL getImgURL5() {
        return imgURL5;
    }

    public static URL getImgURL6() {
        return imgURL6;
    }

    public static URL getImgURL7() {
        return imgURL7;
    }

    public static URL getImgURL8() {
        return imgURL8;
    }

}
