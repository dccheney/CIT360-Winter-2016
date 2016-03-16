package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class ReinstallOS implements Handler {
    public void handleIt(HashMap parameters) {
        System.out.println("Doing a clean install of the Operating System costs $40 if you already ");
        System.out.println("have a product key to activate windows.  If you don't have a product key, then ");
        System.out.println("purchasing a product key will depend on what operating system you choose.  This process ");
        System.out.println("can take anywhere from 4hrs to 3 days.");

    }
}
