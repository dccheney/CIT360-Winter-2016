package APCsandbox;

import java.util.Scanner;

/**
 * Created by Carissa on 2/23/2016.
 */
public class Application {

    public static void main(String[] args) {
        // A simple text scanner which can parse primitive types
        // and strings using regular expressions.
        // Allows the user to read the input from System.in
        Scanner in = new Scanner(System.in);

        ApplicationController controller = new ApplicationController();

        String command;

        System.out.println("Which muffin information would you like to view (Apple Crumble," +
                " Banana Nut, Chocolate Chip, or Blueberry): ");
        command = in.nextLine();

        controller.handleUserCommand(command, null);
    }
}
