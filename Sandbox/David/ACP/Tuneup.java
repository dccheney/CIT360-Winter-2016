package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class Tuneup implements Handler {
    public void handleIt(HashMap parameters) {
        System.out.println("A standard tuneup is $20 and includes cleaning out temporary ");
        System.out.println("internet files, cleaning the registry, optimizing startup, and doing a mild yet ");
        System.out.println("effective malware scan.");
    }
}
