package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class NotFound implements Handler {
    public void handleIt(HashMap parameters) {
        System.out.println("The service you specified is not available. Current service options are: ");
        System.out.println("Tuneup, Advanced Tuneup, Screen Replacement, Reinstall OS, or 250GB SSD upgrade");
    }
}
