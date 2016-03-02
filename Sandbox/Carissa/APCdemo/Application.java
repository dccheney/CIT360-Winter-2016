package APCdemo;

import java.util.Scanner;

/**
 * Created by Carissa on 2/26/2016.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationController delegate = new ApplicationController();

//        String add = "add";
//        String sub = "sub";
//        String mul = "mul";
//        String div = "div";

        Integer num1 = -5;
        Integer num2 = 5;
        String command;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number: ");
        num1 = Integer.parseInt(in.nextLine());

        System.out.println("Enter a command( + , - , * , / ): ");
        command = in.nextLine();

        System.out.println("Enter another number: ");
        num2 = Integer.parseInt(in.nextLine());

        System.out.println(num1 + " " + command + " " + num2 + " = ");
        delegate.handleCommand(command, num1, num2);
    }
}
