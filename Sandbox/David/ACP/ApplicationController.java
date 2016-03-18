package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class ApplicationController {
    private static HashMap<String, Handler> handlerHashMap = new HashMap<String, Handler>();

    public void mapCommand(String aCommand, Handler acHandler) {handlerHashMap.put(aCommand, acHandler);}

    public static void handleUserCommand(String command, HashMap parameters) {
        Handler handler = handlerHashMap.get(command);
        if(handler != null) {
            handler.handleIt(parameters);
        }
    }
}
