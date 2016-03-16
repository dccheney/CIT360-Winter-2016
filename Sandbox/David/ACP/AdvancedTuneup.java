package APC;


import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class AdvancedTuneup implements Handler {
    public void handleIt(HashMap parameters) {
        System.out.println("An advanced tuneup is $40 and includes everything in a standard tuneup ");
        System.out.println("(cleaning out temporary internet files, cleaning the registry, optimizing startup, ");
        System.out.println("and doing a mild yet effective malware scan) as well as more advanced antivirus ");
        System.out.println("removal tools to remove Trojans, rootkits, adware, DNS changers and other dangerous ");
        System.out.println("Viruses.");

    }
}
