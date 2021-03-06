package APC;

import java.util.Scanner;

/**
 * Created by David on 3/15/2016.
 */
public class Application {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        ApplicationController controller = new ApplicationController();

        String command;
        Boolean running = true;
        controller.mapCommand("tuneup", new Tuneup());
        controller.mapCommand("advanced tuneup", new AdvancedTuneup());
        controller.mapCommand("screen replacement", new ScreenReplacement());
        controller.mapCommand("reinstall os", new ReinstallOS());
        controller.mapCommand("250gb ssd upgrade", new SSDUpgrade());

        while (running == true) {
            System.out.println();
            System.out.println("Which service would you like to know more about (Tuneup, Advanced Tuneup,");
            System.out.println("Screen Replacement, Reinstall OS, 250GB SSD upgrade, or enter 'quit' to exit)?");

            command = in.nextLine().toLowerCase();
            if (command.equals("quit"))
                running = false;

            controller.handleUserCommand(command, null);
        }
    }
}
