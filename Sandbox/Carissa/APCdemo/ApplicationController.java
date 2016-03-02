package APCdemo;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * Created by Carissa on 2/26/2016.
 */
public class ApplicationController {
    public static HashMap<String, Handler> hashMapOfCommands = new HashMap<String, Handler>();

    public void ApplicationControllerPattern() {

    }

    public static void handleCommand(String command, Integer num1, Integer num2) {
        hashMapOfCommands.put("+", new Add());
        hashMapOfCommands.put("-", new Subtract());
        hashMapOfCommands.put("*", new Multiply());
        hashMapOfCommands.put("/", new Divide());


        Handler handler = hashMapOfCommands.get(command);
        handler.execute(num1, num2);



    }
}
