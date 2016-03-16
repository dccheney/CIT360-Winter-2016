package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class SSDUpgrade implements Handler {
    public void handleIt(HashMap parameters) {
        System.out.println("Upgrading to a 250GB SSD starts at $130 (SSD: $90, OS install: 40, ");
        System.out.println("Product Key (if needed): $100, Data Transfer: $20/50GB up to $60max). This process ");
        System.out.println("involves removing the old hard drive, installing the new SSD, installing the OS, and ");
        System.out.println("providing any other services required.  The process can take anywhere from 4hrs to 4 days.");
    }
}
