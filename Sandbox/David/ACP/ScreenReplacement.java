package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class ScreenReplacement implements Handler {
    public void handleIt(HashMap parameters) {
        System.out.println("Most screen replacements cost $90-110 (Part: $60-80, Labor $30). ");
        System.out.println("I typically purchase replacement screens from laptopscreen.com who provide a 3 ");
        System.out.println("year warranty from defects. Shipping typically takes 5 business days and I can " );
        System.out.println("have it installed within hours of receiving the part.");

    }
}
