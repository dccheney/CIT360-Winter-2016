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
        while (running == true) {
            System.out.println();
            System.out.println("Which service would you like to know more about (Tuneup, Advanced Tuneup,");
            System.out.println("Screen Replacement, Reinstall OS, 250GB SSD upgrade, or enter 'quit' to exit)?");

            command = in.nextLine();
            if (command.equals("quit"))
                running = false;

            controller.handleUserCommand(command, null);
        }
    }
}
